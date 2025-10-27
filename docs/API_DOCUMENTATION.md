# API Documentation - Collectibles Store

## Base URL
```
http://localhost:4567
```

## API Version
v1

---

## Items Endpoints

### 1. Get All Items

Retrieves a list of all collectible items available in the store.

**Endpoint:** `GET /items`

**Request:**
- Method: GET
- Headers: None required
- Body: None

**Success Response (200 OK):**
```json
[
  {
    "id": "item1",
    "name": "Gorra autografiada por Peso Pluma",
    "description": "Una gorra autografiada por el famoso Peso Pluma.",
    "price": "$621.34 USD"
  },
  {
    "id": "item2",
    "name": "Casco autografiado por Rosalia",
    "description": "Un casco autografiado por la famosa cantante Rosalia, una verdadera MOTOMAMI!",
    "price": "$734.57 USD"
  }
]
```

**Error Response (500 Internal Server Error):**
```json
{
  "error": true,
  "message": "Error retrieving items: [error details]",
  "timestamp": 1234567890123
}
```

**Example cURL:**
```bash
curl -X GET http://localhost:4567/items
```

**Example JavaScript (Fetch):**
```javascript
fetch('http://localhost:4567/items')
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error));
```

---

### 2. Get Item by ID

Retrieves detailed information about a specific collectible item.

**Endpoint:** `GET /items/:id`

**URL Parameters:**
- `id` (string, required): Unique identifier of the item

**Request:**
- Method: GET
- Headers: None required
- Body: None

**Success Response (200 OK):**
```json
{
  "id": "item1",
  "name": "Gorra autografiada por Peso Pluma",
  "description": "Una gorra autografiada por el famoso Peso Pluma.",
  "price": "$621.34 USD"
}
```

**Error Response (404 Not Found):**
```json
{
  "error": true,
  "message": "Item not found with ID: item999",
  "timestamp": 1234567890123
}
```

**Error Response (400 Bad Request):**
```json
{
  "error": true,
  "message": "Item ID is required",
  "timestamp": 1234567890123
}
```

**Error Response (500 Internal Server Error):**
```json
{
  "error": true,
  "message": "Error retrieving item: [error details]",
  "timestamp": 1234567890123
}
```

**Example cURL:**
```bash
curl -X GET http://localhost:4567/items/item1
```

**Example JavaScript (Fetch):**
```javascript
fetch('http://localhost:4567/items/item1')
  .then(response => {
    if (!response.ok) {
      throw new Error('Item not found');
    }
    return response.json();
  })
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error));
```
## Response Formats

### Success Response
All successful responses return the requested data with:
- HTTP Status: 200 OK
- Content-Type: application/json
- Body: JSON object or array

### Error Response
All error responses follow this structure:
```json
{
  "error": true,
  "message": "Human-readable error message",
  "timestamp": 1234567890123
}
```

Common HTTP status codes:
- `200 OK`: Request successful
- `400 Bad Request`: Invalid request parameters
- `404 Not Found`: Resource not found
- `500 Internal Server Error`: Server-side error

---
## Users Endpoints

### 3. Get All Users

Retrieves a list of all users in the system.

**Endpoint:** `GET /users`

**Request:**
- Method: GET
- Headers: None required
- Body: None

**Success Response (200 OK):**
```json
[
  {
    "id": "user1",
    "name": "Admin User",
    "email": "admin@collectibles.com",
    "role": "admin"
  },
  {
    "id": "user2",
    "name": "John Collector",
    "email": "john@email.com",
    "role": "buyer"
  },
  {
    "id": "user3",
    "name": "Ramon Organizer",
    "email": "ramon@email.com",
    "role": "seller"
  }
]
```

**Error Response (500 Internal Server Error):**
```json
{
  "error": true,
  "message": "Error retrieving users: [error details]",
  "timestamp": 1234567890123
}
```

**Example cURL:**
```bash
curl -X GET http://localhost:4567/users
```

**Example JavaScript (Fetch):**
```javascript
fetch('http://localhost:4567/users')
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error));
```

---

### 4. Get User by ID

Retrieves detailed information about a specific user.

**Endpoint:** `GET /users/:id`

**URL Parameters:**
- `id` (string, required): Unique identifier of the user

**Request:**
- Method: GET
- Headers: None required
- Body: None

**Success Response (200 OK):**
```json
{
  "id": "user1",
  "name": "Admin User",
  "email": "admin@collectibles.com",
  "role": "admin"
}
```

**Error Response (404 Not Found):**
```json
{
  "error": true,
  "message": "User not found with ID: user999",
  "timestamp": 1234567890123
}
```

**Error Response (400 Bad Request):**
```json
{
  "error": true,
  "message": "User ID is required",
  "timestamp": 1234567890123
}
```

**Error Response (500 Internal Server Error):**
```json
{
  "error": true,
  "message": "Error retrieving user: [error details]",
  "timestamp": 1234567890123
}
```

**Example cURL:**
```bash
curl -X GET http://localhost:4567/users/user1
```

**Example JavaScript (Fetch):**
```javascript
fetch('http://localhost:4567/users/user1')
  .then(response => {
    if (!response.ok) {
      throw new Error('User not found');
    }
    return response.json();
  })
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error));
```
### 5. Add New User

Creates a new user in the system.

**Endpoint:** `POST /users/:id`

**URL Parameters:**
- `id` (string, required): Unique identifier for the new user

**Request Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "name": "Maria Garcia",
  "email": "maria@example.com",
  "role": "buyer"
}
```

**Field Requirements:**
- `name` (string, required): Full name of the user
- `email` (string, required): Valid email address format
- `role` (string, required): Must be one of: "admin", "buyer", "seller"

**Success Response (201 Created):**
```json
{
  "id": "user4",
  "name": "Maria Garcia",
  "email": "maria@example.com",
  "role": "buyer"
}
```

**Error Response (409 Conflict - Duplicate ID):**
```json
{
  "error": true,
  "message": "User with ID user1 already exists",
  "timestamp": 1234567890123
}
```

**Error Response (400 Bad Request - Missing Field):**
```json
{
  "error": true,
  "message": "User name is required",
  "timestamp": 1234567890123
}
```

**Error Response (400 Bad Request - Invalid Email):**
```json
{
  "error": true,
  "message": "Invalid email format",
  "timestamp": 1234567890123
}
```

**Error Response (400 Bad Request - Invalid Role):**
```json
{
  "error": true,
  "message": "Invalid role. Must be: admin, buyer, or seller",
  "timestamp": 1234567890123
}
```

**Example cURL:**
```bash
curl -X POST http://localhost:4567/users/user4 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Maria Garcia",
    "email": "maria@example.com",
    "role": "buyer"
  }'
```

**Example JavaScript (Fetch):**
```javascript
fetch('http://localhost:4567/users/user4', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    name: 'Maria Garcia',
    email: 'maria@example.com',
    role: 'buyer'
  })
})
  .then(response => {
    if (response.status === 201) {
      return response.json();
    }
    throw new Error('User creation failed');
  })
  .then(data => console.log('User created:', data))
  .catch(error => console.error('Error:', error));
```

---

### 6. Update User

Updates an existing user's information.

**Endpoint:** `PUT /users/:id`

**URL Parameters:**
- `id` (string, required): Unique identifier of the user to update

**Request Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "name": "John Updated",
  "email": "john.updated@example.com",
  "role": "seller"
}
```

**Field Requirements:**
- `name` (string, required): Full name of the user
- `email` (string, required): Valid email address format
- `role` (string, required): Must be one of: "admin", "buyer", "seller"

**Success Response (200 OK):**
```json
{
  "id": "user2",
  "name": "John Updated",
  "email": "john.updated@example.com",
  "role": "seller"
}
```

**Error Response (404 Not Found):**
```json
{
  "error": true,
  "message": "User not found with ID: user999",
  "timestamp": 1234567890123
}
```

**Error Response (400 Bad Request - Missing Field):**
```json
{
  "error": true,
  "message": "User email is required",
  "timestamp": 1234567890123
}
```

**Error Response (400 Bad Request - Invalid Email):**
```json
{
  "error": true,
  "message": "Invalid email format",
  "timestamp": 1234567890123
}
```

**Example cURL:**
```bash
curl -X PUT http://localhost:4567/users/user2 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Updated",
    "email": "john.updated@example.com",
    "role": "seller"
  }'
```

**Example JavaScript (Fetch):**
```javascript
fetch('http://localhost:4567/users/user2', {
  method: 'PUT',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    name: 'John Updated',
    email: 'john.updated@example.com',
    role: 'seller'
  })
})
  .then(response => {
    if (!response.ok) {
      throw new Error('User update failed');
    }
    return response.json();
  })
  .then(data => console.log('User updated:', data))
  .catch(error => console.error('Error:', error));
```

---

## HTTP Status Codes

| Code | Meaning | When Used |
|------|---------|-----------|
| 200 | OK | Successful GET, PUT |
| 201 | Created | Successful POST |
| 400 | Bad Request | Missing/invalid data |
| 404 | Not Found | Resource doesn't exist |
| 409 | Conflict | Duplicate resource |
| 500 | Internal Server Error | Server-side error |
---

## Available Users

The following sample users are available in the system:

| ID | Name | Email | Role |
|----|------|-------|------|
| user1 | Admin User | admin@collectibles.com | admin |
| user2 | John Collector | john@email.com | buyer |
| user3 | Ramon Organizer | ramon@email.com | seller |

### User Roles

- **admin**: System administrator with full access
- **buyer**: Collector who can browse and purchase items
- **seller**: User who can list and sell collectible items
---

## CORS Support

All endpoints support Cross-Origin Resource Sharing (CORS):
- **Allowed Origins:** * (all)
- **Allowed Methods:** GET, POST, PUT, DELETE, OPTIONS
- **Allowed Headers:** Content-Type, Authorization, X-Requested-With

---

## Rate Limiting

Currently, no rate limiting is implemented.

---

## Authentication

Currently, no authentication is required. All endpoints are publicly accessible.
