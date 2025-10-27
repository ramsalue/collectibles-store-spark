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
