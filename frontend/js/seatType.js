const getAllCustomer=()=>{
  $.ajax({
    url: 'http://localhost:8080/api/v1/seat-type/getAll',
    type: "GET",
    success:(res) =>{
      console.log(res)
      $('#customer_table_body').empty()
      res.data.forEach(customer => {
        $('#customer_table_body').append(`
                 <tr>
                    <td>${customer.id}</td>
                    <td>${customer.type}</td>
                       <td>${customer.description}</td>
                    <td>${customer.quantity}</td>
                      <td>${customer.price}</td>



                     <td>
                          <button class="btn btn-light btn-sm" onclick="editCustomer('${customer.id}','${customer.type}','${customer.description}' ,'${customer.quantity}','${customer.price}')">
                           Update
                           </button>
                      </td>
                       <td>
                            <button class="btn btn-light btn-sm" onclick="deleteCustomer('${customer.id}')" >
                              Dalete
                             </button>
                        </td>
                     </tr>

          `)
      })

    },
    errors:(err) =>{
      console.log(err)
    }

  })
}
$(document).ready(function (){
  getAllCustomer();
})

$('#btn_save_customer').click((e) =>{
  e.preventDefault();
  const customerId=$("#id").val();
  const type =$("#type").val();
  const  customerDescription=$('#description').val();
  const  customerUnitPrice=$('#quantity').val();
  const  customerQTY=$('#price').val();


  const customerData ={
    id:customerId,
type : type,
    description: customerDescription,
  quantity: customerUnitPrice,
    price: customerQTY


  };

  $.ajax({
    url:'http://localhost:8080/api/v1/seat-type/save',
    type:"POST",
    data:JSON.stringify(
      customerData
    ),
    contentType:"application/json",
    success:(res) =>{
      getAllCustomer()
      console.log(res)
    },
    errors:(err) =>{
      console.log(err)
    }

  })
})


const deleteCustomer=(id) =>{
  $.ajax({
    url:`http://localhost:8080/api/v1/seat-type/delete/${id}`,
    type:'DELETE',
    success:(res)=>{
      console.log(res)
      getAllCustomer()

    },
    error:(err) =>{
      console.log(err)
    }

  })
}


const editCustomer = (id, type, description,quantity,price) => {
  $('#updated_customer_id').val(id)
  $('#updated_type').val(type)
  $('#updated_description').val(description)
  $('#updated_quantity').val(quantity)
  $('#updated_price').val(price)

  $('#updateCustomerModal').modal('show')
}

$('#btn_update_customer').click((e) => {
  e.preventDefault()
  const id = $('#updated_customer_id').val()
  const  type = $('#updated_type').val()
  const description = $('#updated_description').val()
  const qu = $('#updated_quantity').val()
  const pr = $('#updated_price').val()

  const updateCustomerData = {
    id,
    type,
    description,
    quantity: qu,  // Change to match your DTO field name
    price: pr
  }

  $.ajax({
    url: 'http://localhost:8080/api/v1/seat-type/update',
    type: 'PUT',
    data: JSON.stringify(updateCustomerData),
    contentType: "application/json",
    success: (res) => {
      getAllCustomer()
      console.log(res)
    },
    error: (err) => {
      console.log(err)  // Fixed typo here as well (was 'res')
    }
  })
})
