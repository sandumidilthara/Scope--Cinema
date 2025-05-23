document.getElementById('addSpiceForm').addEventListener('submit', function(event) {
  event.preventDefault();

  const formData = new FormData();
  const spice = {
    name: document.getElementById('spiceName').value,
    contactNumber: document.getElementById('contactNumber').value,
    location: document.getElementById('location').value,
    description: document.getElementById('description').value,
    email: document.getElementById('email').value,
    imageURL: document.getElementById('spiceImageURL').value
  };
  formData.append('spice', JSON.stringify(spice));

  const spiceImageFile = document.getElementById('spiceImageURL');
  if (spiceImageFile && spiceImageFile.files.length > 0) {
    formData.append('file', spiceImageFile.files[0]);
  } else {
    console.error('No image file selected');
    return;
  }

  fetch('http://localhost:8080/api/v1/example/save', {
    method: 'POST',
    body: formData
  })
    .then(response => {
      if (!response.ok) {

        getAllCustomer();
        return response.json().then(errorData => {
          throw new Error(JSON.stringify(errorData));
        });
      }
      return response.json();
    })
    .then(data => {
      console.log('Spice saved successfully:', data);
      getAllCustomer();
    })
    .catch(error => {
      console.error('Error:', error);
      try {
        const errorData = JSON.parse(error.message);
        console.log('Response data:', errorData);
        if (errorData.data) {
          for (const [field, message] of Object.entries(errorData.data)) {
          }
        }
      } catch (e) {
        console.error('Failed to parse error message:', e);
      }
    });
});





const getAllCustomer = () => {
  $.ajax({
    url: 'http://localhost:8080/api/v1/example/get',
    type: "GET",
    success: (res) => {
      console.log(res);
      $('#customer_table_body').empty();


      res.data.forEach(customer => {
        const imageUrl = customer.imageURL ? `data:image/png;base64,${customer.imageURL}` : 'assests/Images/noImage.png';
        $('#customer_table_body').append(`
          <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.contactNumber}</td>
            <td>${customer.location}</td>
            <td>${customer.description}</td>
            <td>${customer.email}</td>
            <td><img src="${imageUrl}" alt="Customer Image" style="width: 100px; height: auto;"></td>
            <td>
              <button class="btn btn-light btn-sm" onclick="editCustomer('${customer.id}','${customer.name}','${customer.contactNumber}','${customer.location}','${customer.description}','${customer.email}')">
                Update
              </button>
            </td>
            <td>
              <button class="btn btn-light btn-sm" onclick="deleteCustomer('${customer.id}')">
                Delete
              </button>
            </td>
          </tr>
        `);
      });
    },
    error: (err) => {
      console.log(err);
    }
  });
};


$(document).ready(function (){
  getAllCustomer();
})






const deleteCustomer=(id) =>{
  $.ajax({
    url:`http://localhost:8080/api/v1/example/delete/${id}`,
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


























const editCustomer=(id,name, contactNumber,location,description,email) =>{
  $('#updated_film_id').val(id)

  $('#updated_film_name').val(name)
  $('#updated_capacity').val(contactNumber)
  $('#updated_location').val(location)
  $('#updated_description').val(description)
  $('#updated_hall').val(email)
  $('#updateCustomerModal').modal('show')

}




$('#btn_update_customer').click((e) => {
  e.preventDefault(); // Prevent the default form submission

  // Create a new FormData object
  const updateCustomerData = new FormData();

  // Append form data to the FormData object
  updateCustomerData.append('spice', JSON.stringify({
    id: $('#updated_film_id').val(),
    name: $('#updated_film_name').val(),
    contactNumber: $('#updated_capacity').val(),
    location: $('#updated_location').val(),
    description: $('#updated_description').val(),
    email: $('#updated_hall').val()
  }));

  const updatedImageFile = $('#edit_image')[0].files[0]; // Get the file from the input
  if (updatedImageFile) {
    updateCustomerData.append('file', updatedImageFile); // Use 'file' as the key
  }

  // Send the FormData object
  $.ajax({
    url: 'http://localhost:8080/api/v1/example/update', // Your API endpoint
    type: 'PUT',
    data: updateCustomerData,
    processData: false, // Prevent jQuery from automatically transforming the data into a query string
    contentType: false, // Set content type to false to let the browser set it
    success: (res) => {
      console.log('Update successful:', res);
      getAllCustomer(); // Refresh the customer list
      $('#updateCustomerModal').modal('hide'); // Hide the modal after successful update
    },
    error: (err) => {
      console.error('Update failed:', err); // Log any errors
    }
  });
});
