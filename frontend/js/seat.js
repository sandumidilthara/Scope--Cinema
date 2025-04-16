// $('#load-cus-ids').click((e) => {
//   e.preventDefault();
//
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/seat-type/getAll',
//     type: 'GET',
//     success: (res) => {
//       console.log(res);
//
//       // Clear existing options
//       $('#load-film-id').empty();
//
//       // Add default option
//       $('#load-film-id').append('<option value="">-- Select Time Table --</option>');
//
//       // Add options from response data
//       if (res.data && res.data.length > 0) {
//         res.data.forEach(film => {
//           $('#load-film-id').append(`<option value="${film.id}">${film.type}</option>`);
//         });
//       } else {
//         console.log("No data found in response");
//       }
//     },
//     error: (err) => {
//       console.log(err);
//     }
//   });
// });
//
// // Optional: To capture the selected value
// $('#load-film-id').change(function() {
//   const selectedId = $(this).val();
//   const selectedName = $(this).find("option:selected").text();
//   console.log("Selected ID:", selectedId);
//   console.log("Selected Name:", selectedName);
//
//   // You can use these values as needed
//   // For example, populate other fields:
//   // $('#someOtherField').val(selectedId);
// });
//
//
//
// $('#updated_load-cus-ids').click((e) => {
//   e.preventDefault();
//
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/seat-type/getAll',
//     type: 'GET',
//     success: (res) => {
//       console.log(res);
//
//       // Clear existing options
//       $('#updated_load-film-id').empty();
//
//       // Add default option
//       $('#updated_load-film-id').append('<option value="">-- Select Time Table --</option>');
//
//       // Add options from response data
//       if (res.data && res.data.length > 0) {
//         res.data.forEach(film => {
//           $('#updated_load-film-id').append(`<option value="${film.id}">${film.type}</option>`);
//         });
//       } else {
//         console.log("No data found in response");
//       }
//     },
//     error: (err) => {
//       console.log(err);
//     }
//   });
// });
//
// // Optional: To capture the selected value
// $('#updated_load-film-id').change(function() {
//   const selectedId = $(this).val();
//   const selectedName = $(this).find("option:selected").text();
//   console.log("Selected ID:", selectedId);
//   console.log("Selected Name:", selectedName);
//
//   // You can use these values as needed
//   // For example, populate other fields:
//   // $('#someOtherField').val(selectedId);
// });
//
//
//
//
// $('#btn_save_customer').click((e) => {
//   e.preventDefault();
//   const seatId = $("#id").val();
//   const rowLetter = $("#rowLetter").val();
//   const seatNumber = $("#seatNumber").val();
//   const isAvailable = $("#isAvailable").is(":checked");
//   const seatTypeId = $('#load-film-id').val();
//   const filmHallId = $('#load-hall-id').val();
//
//   console.log(seatTypeId);
//
//   if (!seatId || !rowLetter || !seatNumber || !seatTypeId) {
//     alert("Please fill in all required fields");
//     return;
//   }
//
//   const seatData = {
//     id: seatId,
//     rowLetter: rowLetter,
//     seatNumber: (parseInt(seatNumber)),
//     isAvailable: isAvailable,
//     seatType: {
//       id: seatTypeId
//     },
//     filmHall : {
//       id : filmHallId
//     }
//   };
//
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/seat/save',
//     type: "POST",
//     data: JSON.stringify(seatData),
//     contentType: "application/json",
//     success: (res) => {
//       console.log(res);
//       getAllCustomer();
//       alert("Seat saved successfully!");
//       $('#customerModal').modal('hide');
//      // clearForm();
//       // Add a function to reload data if you have one
//     },
//     error: (err) => {
//       console.log(err);
//       alert("Error saving seat: " + (err.responseJSON?.message || "Unknown error"));
//     }
//   });
// });
//
//
//
//
//
// const getAllCustomer=()=>{
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/seat/getAll',
//     type: "GET",
//     success:(res) =>{
//       console.log(res)
//       $('#customer_table_body').empty()
//       res.data.forEach(customer => {
//         $('#customer_table_body').append(`
//                  <tr>
//                     <td>${customer.id}</td>
//                        <td>${customer.rowLetter}</td>
//                     <td>${customer.seatNumber}</td>
//                       <td>${customer.isAvailable}</td>
//                        <td>${customer.seatType}</td>
//                          <td>${customer.filmHall}</td>
//
//                      <td>
//                           <button class="btn btn-light btn-sm" onclick="editCustomer('${customer.id}','${customer.rowLetter}','${customer.seatNumber}' ,'${customer.isAvailable}','${customer.seatType}','${customer.filmHall}')" >
//                            Update
//                            </button>
//                       </td>
//                        <td>
//                             <button class="btn btn-light btn-sm" onclick="deleteCustomer('${customer.id}')" >
//                               Dalete
//                              </button>
//                         </td>
//                      </tr>
//
//           `)
//       })
//
//     },
//     errors:(err) =>{
//       console.log(err)
//     }
//
//   })
// }
//
// $(document).ready(function (){
//   getAllCustomer();
// })
//
//
//
//
// const deleteCustomer=(id) =>{
//   $.ajax({
//     url:`http://localhost:8080/api/v1/seat/delete/${id}`,
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
//
//
// $('#load-hall-ids').click((e) => {
//   e.preventDefault();
//
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/example/get', // Updated URL
//     type: 'GET',
//     success: (res) => {
//       console.log(res);
//
//       // Clear existing options
//       $('#load-hall-id').empty();
//
//       // Add default option
//       $('#load-hall-id').append('<option value="">-- Select Time Table --</option>');
//
//       // Add options from response data
//       if (res.data && res.data.length > 0) {
//         res.data.forEach(spice => { // Updated variable name
//           $('#load-hall-id').append(`<option value="${spice.id}">${spice.name}</option>`);
//         });
//       } else {
//         console.log("No data found in response");
//       }
//     },
//     error: (err) => {
//       console.log(err);
//     }
//   });
// });
//
//
//
//
// $('#updated_load-hall-ids').click((e) => {
//   e.preventDefault();
//
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/example/get', // Updated URL
//     type: 'GET',
//     success: (res) => {
//       console.log(res);
//
//       // Clear existing options
//       $('#updated_load-hall-id').empty();
//
//       // Add default option
//       $('#updated_load-hall-id').append('<option value="">-- Select Time Table --</option>');
//
//       // Add options from response data
//       if (res.data && res.data.length > 0) {
//         res.data.forEach(spice => { // Updated variable name
//           $('#updated_load-hall-id').append(`<option value="${spice.id}">${spice.name}</option>`);
//         });
//       } else {
//         console.log("No data found in response");
//       }
//     },
//     error: (err) => {
//       console.log(err);
//     }
//   });
// });
//
//
//
//
//
// const editCustomer = (id, rowLetter, seatNumber, isAvailable, seatType, filmHall) => {
//   // Open the update modal
//   $('#updateCustomerModal').modal('show');
//
//   // Set the values in the form fields
//   $('#updated_id').val(id);
//   $('#updated_rowLetter').val(rowLetter);
//   $('#updated_seatNumber').val(seatNumber);
//
//   // Set the checkbox value
//   $('#updated_isAvailable').prop('checked', isAvailable === 'true');
//
//   if ($('#updated_load-film-id option[value="' +   seatType + '"]').length === 0) {
//     $('#updated_load-film-id').append('<option value="' + seatType + '">' + seatType + '</option>');
//   }
//
//   // Set the dropdown value to hallName
//   $('#updated_load-film-id').val(seatType);
//
//
//
//
//
//   if ($('#updated_load-hall-id option[value="' +  filmHall + '"]').length === 0) {
//     $('#updated_load-hall-id').append('<option value="' + filmHall + '">' + filmHall + '</option>');
//   }
//
//   // Set the dropdown value to hallName
//   $('#updated_load-hall-id').val(filmHall);
// }
//
//
// $('#btn_update_customer').click((e) => {
//   e.preventDefault();
//
//   const seatId = $("#updated_id").val();
//   const rowLetter = $("#updated_rowLetter").val();
//   const seatNumber = $("#updated_seatNumber").val();
//   const isAvailable = $("#updated_isAvailable").is(":checked");
//   const seatTypeId = $('#updated_load-film-id').val();
//   const filmHallId = $('#updated_load-hall-id').val();
//
//   if (!seatId || !rowLetter || !seatNumber || !seatTypeId || !filmHallId) {
//     alert("Please fill in all required fields");
//     return;
//   }
//
//   const seatData = {
//     id: seatId,
//     rowLetter: rowLetter,
//     seatNumber: parseInt(seatNumber),
//     isAvailable: isAvailable,
//     seatType: {
//       id: seatTypeId
//     },
//     filmHall: {
//       id: filmHallId
//     }
//   };
//
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/seat/update',
//     type: "PUT",
//     data: JSON.stringify(seatData),
//     contentType: "application/json",
//     success: (res) => {
//       console.log(res);
//       getAllCustomer();
//       alert("Seat updated successfully!");
//       $('#updateCustomerModal').modal('hide');
//     },
//     error: (err) => {
//       console.log(err);
//       alert("Error updating seat: " + (err.responseJSON?.message || "Unknown error"));
//     }
//   });
// })
// Function to load seat types
function loadSeatTypes(selectElement) {
  $.ajax({
    url: 'http://localhost:8080/api/v1/seat-type/getAll',
    type: 'GET',
    success: (res) => {
      console.log(res);

      // Clear existing options
      $(selectElement).empty();

      // Add default option
      $(selectElement).append('<option value="">-- Select Time Table --</option>');

      // Add options from response data
      if (res.data && res.data.length > 0) {
        res.data.forEach(film => {
          $(selectElement).append(`<option value="${film.id}">${film.type}</option>`);
        });
      } else {
        console.log("No data found in response");
      }
    },
    error: (err) => {
      console.log(err);
    }
  });
}

// Function to load film halls
function loadFilmHalls(selectElement) {
  $.ajax({
    url: 'http://localhost:8080/api/v1/example/get',
    type: 'GET',
    success: (res) => {
      console.log(res);

      // Clear existing options
      $(selectElement).empty();

      // Add default option
      $(selectElement).append('<option value="">-- Select Film Hall --</option>');

      // Add options from response data
      if (res.data && res.data.length > 0) {
        res.data.forEach(spice => {
          $(selectElement).append(`<option value="${spice.id}">${spice.name}</option>`);
        });
      } else {
        console.log("No data found in response");
      }
    },
    error: (err) => {
      console.log(err);
    }
  });
}

// Add click-once flag variables
let filmIdClicked = false;
let hallIdClicked = false;
let updatedFilmIdClicked = false;
let updatedHallIdClicked = false;

// Event listener for when the modal is shown
$('#customerModal').on('shown.bs.modal', function () {
  // Reset the flags when modal opens
  filmIdClicked = false;
  hallIdClicked = false;
});

$('#updateCustomerModal').on('shown.bs.modal', function () {
  // Reset the flags when modal opens
  updatedFilmIdClicked = false;
  updatedHallIdClicked = false;
});

// Load seat types when dropdown is clicked for the first time
$('#load-film-id').on('mousedown', function() {
  if (!filmIdClicked) {
    loadSeatTypes('#load-film-id');
    filmIdClicked = true;
  }
});

// Load film halls when dropdown is clicked for the first time
$('#load-hall-id').on('mousedown', function() {
  if (!hallIdClicked) {
    loadFilmHalls('#load-hall-id');
    hallIdClicked = true;
  }
});

// Load seat types when update dropdown is clicked for the first time
$('#updated_load-film-id').on('mousedown', function() {
  if (!updatedFilmIdClicked) {
    loadSeatTypes('#updated_load-film-id');
    updatedFilmIdClicked = true;
  }
});

// Load film halls when update dropdown is clicked for the first time
$('#updated_load-hall-id').on('mousedown', function() {
  if (!updatedHallIdClicked) {
    loadFilmHalls('#updated_load-hall-id');
    updatedHallIdClicked = true;
  }
});

// Optional: To capture the selected value
$('#load-film-id').change(function() {
  const selectedId = $(this).val();
  const selectedName = $(this).find("option:selected").text();
  console.log("Selected ID:", selectedId);
  console.log("Selected Name:", selectedName);
});

// Optional: To capture the selected value
$('#updated_load-film-id').change(function() {
  const selectedId = $(this).val();
  const selectedName = $(this).find("option:selected").text();
  console.log("Selected ID:", selectedId);
  console.log("Selected Name:", selectedName);
});

$('#btn_save_customer').click((e) => {
  e.preventDefault();
  const seatId = $("#id").val();
  const rowLetter = $("#rowLetter").val();
  const seatNumber = $("#seatNumber").val();
  const isAvailable = $("#isAvailable").is(":checked");
  const seatTypeId = $('#load-film-id').val();
  const filmHallId = $('#load-hall-id').val();

  console.log(seatTypeId);

  if (!seatId || !rowLetter || !seatNumber || !seatTypeId) {
    alert("Please fill in all required fields");
    return;
  }

  const seatData = {
    id: seatId,
    rowLetter: rowLetter,
    seatNumber: (parseInt(seatNumber)),
    isAvailable: isAvailable,
    seatType: {
      id: seatTypeId
    },
    filmHall : {
      id : filmHallId
    }
  };

  $.ajax({
    url: 'http://localhost:8080/api/v1/seat/save',
    type: "POST",
    data: JSON.stringify(seatData),
    contentType: "application/json",
    success: (res) => {
      console.log(res);
      getAllCustomer();
      alert("Seat saved successfully!");
      $('#customerModal').modal('hide');
      // clearForm();
      // Add a function to reload data if you have one
    },
    error: (err) => {
      console.log(err);
      alert("Error saving seat: " + (err.responseJSON?.message || "Unknown error"));
    }
  });
});

const getAllCustomer=()=>{
  $.ajax({
    url: 'http://localhost:8080/api/v1/seat/getAll',
    type: "GET",
    success:(res) =>{
      console.log(res)
      $('#customer_table_body').empty()
      res.data.forEach(customer => {
        $('#customer_table_body').append(`
                 <tr>
                    <td>${customer.id}</td>
                       <td>${customer.rowLetter}</td>
                    <td>${customer.seatNumber}</td>
                      <td>${customer.isAvailable}</td>
                       <td>${customer.seatType}</td>
                         <td>${customer.filmHall}</td>

                     <td>
                          <button class="btn btn-light btn-sm" onclick="editCustomer('${customer.id}','${customer.rowLetter}','${customer.seatNumber}' ,'${customer.isAvailable}','${customer.seatType}','${customer.filmHall}')" >
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
});

const deleteCustomer=(id) =>{
  $.ajax({
    url:`http://localhost:8080/api/v1/seat/delete/${id}`,
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

const editCustomer = (id, rowLetter, seatNumber, isAvailable, seatType, filmHall) => {
  // Open the update modal
  $('#updateCustomerModal').modal('show');

  // Set the values in the form fields
  $('#updated_id').val(id);
  $('#updated_rowLetter').val(rowLetter);
  $('#updated_seatNumber').val(seatNumber);

  // Set the checkbox value
  $('#updated_isAvailable').prop('checked', isAvailable === 'true');

  if ($('#updated_load-film-id option[value="' +   seatType + '"]').length === 0) {
    $('#updated_load-film-id').append('<option value="' + seatType + '">' + seatType + '</option>');
  }

  // Set the dropdown value to hallName
  $('#updated_load-film-id').val(seatType);

  if ($('#updated_load-hall-id option[value="' +  filmHall + '"]').length === 0) {
    $('#updated_load-hall-id').append('<option value="' + filmHall + '">' + filmHall + '</option>');
  }

  // Set the dropdown value to hallName
  $('#updated_load-hall-id').val(filmHall);
}

$('#btn_update_customer').click((e) => {
  e.preventDefault();

  const seatId = $("#updated_id").val();
  const rowLetter = $("#updated_rowLetter").val();
  const seatNumber = $("#updated_seatNumber").val();
  const isAvailable = $("#updated_isAvailable").is(":checked");
  const seatTypeId = $('#updated_load-film-id').val();
  const filmHallId = $('#updated_load-hall-id').val();

  if (!seatId || !rowLetter || !seatNumber || !seatTypeId || !filmHallId) {
    alert("Please fill in all required fields");
    return;
  }

  const seatData = {
    id: seatId,
    rowLetter: rowLetter,
    seatNumber: parseInt(seatNumber),
    isAvailable: isAvailable,
    seatType: {
      id: seatTypeId
    },
    filmHall: {
      id: filmHallId
    }
  };

  $.ajax({
    url: 'http://localhost:8080/api/v1/seat/update',
    type: "PUT",
    data: JSON.stringify(seatData),
    contentType: "application/json",
    success: (res) => {
      console.log(res);
      getAllCustomer();
      alert("Seat updated successfully!");
      $('#updateCustomerModal').modal('hide');
    },
    error: (err) => {
      console.log(err);
      alert("Error updating seat: " + (err.responseJSON?.message || "Unknown error"));
    }
  });
});
