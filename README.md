# API VirtualShop
## Get Popular Products

**URL: https://prueba-tecnica-experimentality.herokuapp.com**
* **URL:** /products/popular
* **Method:** GET

### Response
```bash
 {
    "products": [
        {
            "name": "Camibuso",
            "image": "https://firebasestorage.googleapis.com/v0/b/proyecto3ti.appspot.com/o/camisbuso.jpg?alt=media&token=7897e9ca-c8d7-470f-9a2c-ff6fee28cbfa",
            "backgroundImage": "https://firebasestorage.googleapis.com/v0/b/proyecto3ti.appspot.com/o/camibusoBack.jpg?alt=media&token=275db731-6ae6-40f7-9638-42b8f9be66ea",
            "percent": 10,
            "discountPrice": 10000,
            "id": 1,
            "price": 5000
        },
        {
            "price": 40000,
            "discountPrice": 20000,
            "id": 2,
            "percent": 20,
            "image": "https://firebasestorage.googleapis.com/v0/b/proyecto3ti.appspot.com/o/camisa.jpg?alt=media&token=09342963-f7db-483e-a038-6a21316d167d",
            "backgroundImage": "https://firebasestorage.googleapis.com/v0/b/proyecto3ti.appspot.com/o/camisa.jpg?alt=media&token=09342963-f7db-483e-a038-6a21316d167d",
            "name": "Camisa"
        },
        {
            "name": "Gafas",
            "backgroundImage": "https://firebasestorage.googleapis.com/v0/b/proyecto3ti.appspot.com/o/gafas.png?alt=media&token=8ef6af1f-ad7c-4a31-abef-b63410e8e787",
            "id": 15,
            "price": 4000,
            "image": "https://firebasestorage.googleapis.com/v0/b/proyecto3ti.appspot.com/o/gafas.png?alt=media&token=8ef6af1f-ad7c-4a31-abef-b63410e8e787",
            "percent": 10,
            "discountPrice": 4000
        }
    ]
}
```
## Get Search Product

* **URL:** /products/query?search= &pagination=
* **Method:** GET
* **Params:** GET
    * search
    * pagination

*Example:* https://prueba-tecnica-experimentality.herokuapp.com/products/query?search=gafas&pagination=0

### Response

```bash
{
    "totalPages": 1,
    "products": [
        {
            "name": "Gafas",
            "backgroundImage": "https://firebasestorage.googleapis.com/v0/b/proyecto3ti.appspot.com/o/gafas.png?alt=media&token=8ef6af1f-ad7c-4a31-abef-b63410e8e787",
            "id": 15,
            "price": 4000,
            "image": "https://firebasestorage.googleapis.com/v0/b/proyecto3ti.appspot.com/o/gafas.png?alt=media&token=8ef6af1f-ad7c-4a31-abef-b63410e8e787",
            "percent": 10,
            "discountPrice": 4000
        }
    ]
}
```
## Get Product By Id

* **URL:** /products/${id}
* **Method:** GET

### Response
```bash
{
    "products": {
        "id": 15,
        "name": "Gafas",
        "descripcion": "Gafas de sol",
        "price": 4000,
        "discountPrice": 4000,
        "percent": 10,
        "image": "http:///dasdasd.com.com",
        "backgroundImage": "http:///dasdasd.com.com/back"
    }
}
```
## Create Product

* **URL:** /products
* **Method:** POST

### Request
```bash
{
    "name": "Gafas",
    "descripcion": "Gafas de sol",
    "price": 4000,
    "discountPrice": 4000,
    "percent": 10,
    "image": "http:///dasdasd.com.com",
    "backgroundImage":"http:///dasdasd.com.com/back"
}
```

### Response
```bash
{
    "id": 15,
    "name": "Gafas",
    "descripcion": "Gafas de sol",
    "price": 4000,
    "discountPrice": 4000,
    "percent": 10,
    "image": "http:///dasdasd.com.com",
    "backgroundImage": "http:///dasdasd.com.com/back"
}
```
