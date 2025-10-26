post man jsnon end point details:
  1. add product post Url : http://localhost:8080/api/product/addProduct
     Body -->raw -->json 
              {
                  "name": "Digital pen",
                  "quantity": "2",
                  "price": "50000.00"
              }

  2. add product post Url : http://localhost:8080/api/product/addProducts
     [
        {
            "name": "TCL",
            "quantity": "1",
            "price": "150000.00"
        },
        {
            "name": "Sony",
            "quantity": "2",
            "price": "250000.00"
        }
     ]
3. Get request by name : http://localhost:8080/api/product/id/tv
4. Get request by Id : http://localhost:8080/api/product/id/8
5. Delete request by Id : http://localhost:8080/api/product/id/7
6. update requst by Id : http://localhost:8080/api/product/update/8
        {
        "name": "Data Engines",
        "quantity": "1",
        "price": "2000.00"
        }
 7.Get request for all products : http://localhost:8080/api/product/all
