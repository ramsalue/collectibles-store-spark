package com.collectibles.controller;

import com.collectibles.model.User;
import com.collectibles.service.UserService;
import com.collectibles.util.JsonUtil;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller class for handling user-related HTTP requests.
 * This class acts as the bridge between HTTP routes and the UserService,
 * handling request parsing and response formatting.
 *
 * @author Rafael
 * @version 1.0.0
 */
public class UserController {

    private final UserService userService;

    /**
     * Constructor that receives the UserService dependency.
     *
     * @param userService Service for user operations
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handles GET /users request to retrieve all users.
     *
     * @param request Spark request object
     * @param response Spark response object
     * @return JSON string containing all users
     */
    public String getAllUsers(Request request, Response response) {
        try {
            // Get all users from service
            List<User> users = userService.getAllUsers();

            // Set response status and type
            response.status(200);
            response.type("application/json");

            // Convert users list to JSON and return
            return JsonUtil.toJson(users);

        } catch (Exception e) {
            // Handle unexpected errors
            response.status(500);
            return createErrorResponse("Error retrieving users: " + e.getMessage());
        }
    }

    /**
     * Handles GET /users/:id request to retrieve a specific user.
     *
     * @param request Spark request object containing the user ID parameter
     * @param response Spark response object
     * @return JSON string containing the user or error message
     */
    public String getUserById(Request request, Response response) {
        try {
            // Extract user ID from URL parameter
            String userId = request.params(":id");

            // Validate that ID was provided
            if (userId == null || userId.trim().isEmpty()) {
                response.status(400);
                return createErrorResponse("User ID is required");
            }

            // Get user from service
            User user = userService.getUserById(userId);

            // Check if user was found
            if (user == null) {
                response.status(404);
                return createErrorResponse("User not found with ID: " + userId);
            }

            // Set response status and type
            response.status(200);
            response.type("application/json");

            // Convert user to JSON and return
            return JsonUtil.toJson(user);

        } catch (Exception e) {
            // Handle unexpected errors
            response.status(500);
            return createErrorResponse("Error retrieving user: " + e.getMessage());
        }
    }

    /**
     * Creates a standardized error response in JSON format.
     *
     * @param message The error message
     * @return JSON string with error details
     */
    private String createErrorResponse(String message) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", true);
        errorResponse.put("message", message);
        errorResponse.put("timestamp", System.currentTimeMillis());
        return JsonUtil.toJson(errorResponse);
    }

    /**
     * Creates a standardized success response with data.
     *
     * @param data The data to include in the response
     * @return JSON string with success details
     */
    private String createSuccessResponse(Object data) {
        Map<String, Object> successResponse = new HashMap<>();
        successResponse.put("success", true);
        successResponse.put("data", data);
        successResponse.put("timestamp", System.currentTimeMillis());
        return JsonUtil.toJson(successResponse);
    }
}