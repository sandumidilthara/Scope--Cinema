

// const getAllCustomer = () => {
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/film-hall/getAll',
//     type: "GET",
//     success: (res) => {
//       console.log(res);
//       $('#customer_table_body').empty();
//       res.data.forEach(customer => {
//         $('#customer_table_body').append(`
//           <tr>
//             <td>${customer.id}</td>
//             <td>${customer.name}</td>
//             <td>${customer.totalCapacity}</td>
//             <td>${customer.location}</td>
//             <td>${customer.description}</td>
//             <td>${customer.hallType}</td>
//             <td><img src="${customer.image}" alt="Customer Image" style="width: 100px; height: auto;"></td>
//             <td>
//               <button class="btn btn-light btn-sm" onclick="editCustomer('${customer.id}','${customer.name}','${customer.totalCapacity}','${customer.location}','${customer.description}','${customer.hallType}')">
//                 Update
//               </button>
//             </td>
//             <td>
//               <button class="btn btn-light btn-sm" onclick="deleteCustomer('${customer.id}')">
//                 Delete
//               </button>
//             </td>
//           </tr>
//         `);
//       });
//     },
//     error: (err) => {
//       console.log(err);
//     }
//   });
// };
//
//
// $(document).ready(function (){
//   getAllCustomer();
// })
//
//
// $('#btn_save_customer').click((e) => {
//   e.preventDefault();
//
//   // Create a new FormData object
//   const customerData = new FormData();
//
//   // Append form data to the FormData object
//   customerData.append('id', $("#id").val());
//   customerData.append('name', $('#name').val());
//   customerData.append('totalCapacity', $('#capacity').val());
//   customerData.append('location', $('#location').val());
//   customerData.append('description', $('#description').val());
//   customerData.append('hallType', $('#hall').val());
//   customerData.append('image', $('#image')[0].files[0]); // Assuming #image is an input of type="file"
//
//   // Send the FormData object
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/film-hall/save',
//     type: "POST",
//     data: customerData,
//     processData: false, // Prevent jQuery from automatically transforming the data into a query string
//     contentType: false, // Set content type to false to let the browser set it
//     success: (res) => {
//       getAllCustomer(); // Refresh the customer list
//       console.log(res);
//     },
//     error: (err) => {
//       console.log(err); // Log any errors
//     }
//   });
// });
//
//
// const deleteCustomer=(id) =>{
//   $.ajax({
//     url:`http://localhost:8080/api/v1/film-hall/delete/${id}`,
//     type:'DELETE',
//     success:(res)=>{
//       console.log(res)
//       getAllCustomer()
//
//     },
//     error:(err) =>{
//       console.log(err)
//     }
//
//   })
// }
//
// const editCustomer=(id,name, totalCapacity,location,description,hallType) =>{
//   $('#updated_film_id').val(id)
//   $('#updated_film_name').val(name)
//   $('#updated_capacity').val(totalCapacity)
//   $('#updated_location').val(location)
//   $('#updated_description').val(description)
//   $('#updated_hall').val(hallType)
//
//
//   $('#updateCustomerModal').modal('show')
// }
//
//
//
// $('#btn_update_customer').click((e) => {
//   e.preventDefault(); // Prevent the default form submission
//
//   // Create a new FormData object
//   const updateCustomerData = new FormData();
//
//   // Append form data to the FormData object
//   updateCustomerData.append('id', $('#updated_film_id').val());
//   updateCustomerData.append('name', $('#updated_film_name').val());
//   updateCustomerData.append('totalCapacity', $('#updated_capacity').val());
//   updateCustomerData.append('location', $('#updated_location').val());
//   updateCustomerData.append('description', $('#updated_description').val());
//   updateCustomerData.append('hallType', $('#updated_hall').val());
//   const updatedImageFile = updateCustomerData.append('image', $('#edit_image')[0].files[0]);
//   // Get the file from the input and append it if it exists
//   // const updatedImageFile = $('#updated_image')[0].files[0]; // Get the file from the input
//   if (updatedImageFile) {
//     updateCustomerData.append('image', updatedImageFile);
//   }
//
//   // Send the FormData object
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/film-hall/update', // Your API endpoint
//     type: 'PUT',
//     data: updateCustomerData,
//     processData: false, // Prevent jQuery from automatically transforming the data into a query string
//     contentType: false, // Set content type to false to let the browser set it
//     success: (res) => {
//       console.log('Update successful:', res);
//       getAllCustomer(); // Refresh the customer list
//       $('#updateCustomerModal').modal('hide'); // Hide the modal after successful update
//     },
//     error: (err) => {
//       console.error('Update failed:', err); // Log any errors
//     }
//   });
// });

document.getElementById('addSpiceForm').addEventListener('submit', function(event) {
  event.preventDefault();

  const formData = new FormData();
  const spice = {
    name: document.getElementById('name').value,
    totalCapacity: document.getElementById('totalCapacity').value,
    location: document.getElementById('location').value,
    description: document.getElementById('description').value,
    hallType: document.getElementById('hallType').value,
    imageURL: document.getElementById('imageURL').value
  };
  formData.append('spice', JSON.stringify(spice));

  const spiceImageFile = document.getElementById('imageURL');
  if (spiceImageFile && spiceImageFile.files.length > 0) {
    formData.append('file', spiceImageFile.files[0]);
  } else {
    console.error('No image file selected');
    return;
  }

  fetch('http://localhost:8080/api/v1/film-hall/save', {
    method: 'POST',
    body: formData
  })
    .then(response => {
      if (!response.ok) {
        return response.json().then(errorData => {
          throw new Error(JSON.stringify(errorData));
        });
      }
      return response.json();
    })
    .then(data => {
      console.log('Spice saved successfully:', data);
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
