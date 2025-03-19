const getAllCustomer=()=>{
  $.ajax({
    url: 'http://localhost:8080/api/v1/time-table/getAll',
    type: "GET",
    success:(res) =>{
      console.log(res)
      $('#customer_table_body').empty()
      res.data.forEach(customer => {
        $('#customer_table_body').append(`
                 <tr>
                    <td>${customer.id}</td>
                       <td>${customer.description}</td>
                    <td>${customer.showTime}</td>
                      <td>${customer.endTime}</td>



                     <td>
                          <button class="btn btn-light btn-sm" onclick="editCustomer('${customer.id}','${customer.description}','${customer.showTime}' ,'${customer.endTime}')">
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

  const  customerDescription=$('#description').val();
  const  customerUnitPrice=$('#showTime').val();
  const  customerQTY=$('#endTime').val();


  const customerData ={
    id:customerId,

    description: customerDescription,
  showTime: customerUnitPrice,
    endTime: customerQTY


  };

  $.ajax({
    url:'http://localhost:8080/api/v1/time-table/save',
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
    url:`http://localhost:8080/api/v1/time-table/delete/${id}`,
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


const editCustomer = (id, description, showTime, endTime) => {
  $('#updated_customer_id').val(id)
  $('#updated_description').val(description)
  $('#updated_show_time').val(showTime)
  $('#updated_end_time').val(endTime)

  $('#updateCustomerModal').modal('show')
}

$('#btn_update_customer').click((e) => {
  e.preventDefault()
  const id = $('#updated_customer_id').val()
  const description = $('#updated_description').val()
  const showTime = $('#updated_show_time').val()
  const endTime = $('#updated_end_time').val()

  const updateCustomerData = {
    id,
    description,
    showTime,
    endTime
  }

  $.ajax({
    url: 'http://localhost:8080/api/v1/time-table/update',
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
