$('#load-cus-ids').click((e) => {
  e.preventDefault();

  $.ajax({
    url: 'http://localhost:8080/api/v1/time-table/getAll',
    type: 'GET',
    success: (res) => {
      console.log(res);

      // Clear existing options
      $('#load-film-id').empty();

      // Add default option
      $('#load-film-id').append('<option value="">-- Select Time Table --</option>');

      // Add options from response data
      if (res.data && res.data.length > 0) {
        res.data.forEach(film => {
          $('#load-film-id').append(`<option value="${film.id}">${film.description}</option>`);
        });
      } else {
        console.log("No data found in response");
      }
    },
    error: (err) => {
      console.log(err);
    }
  });
});

// Optional: To capture the selected value
$('#load-film-id').change(function() {
  const selectedId = $(this).val();
  const selectedName = $(this).find("option:selected").text();
  console.log("Selected ID:", selectedId);
  console.log("Selected Name:", selectedName);

  // You can use these values as needed
  // For example, populate other fields:
  // $('#someOtherField').val(selectedId);
});





$('#load-hall-ids').click((e) => {
  e.preventDefault();

  $.ajax({
    url: 'http://localhost:8080/api/v1/example/get', // Updated URL
    type: 'GET',
    success: (res) => {
      console.log(res);

      // Clear existing options
      $('#load-hall-id').empty();

      // Add default option
      $('#load-hall-id').append('<option value="">-- Select Time Table --</option>');

      // Add options from response data
      if (res.data && res.data.length > 0) {
        res.data.forEach(spice => { // Updated variable name
          $('#load-hall-id').append(`<option value="${spice.id}">${spice.name}</option>`);
        });
      } else {
        console.log("No data found in response");
      }
    },
    error: (err) => {
      console.log(err);
    }
  });
});

// Optional: To capture the selected value
$('#load-hall-id').change(function() {
  const selectedId = $(this).val();
  const selectedName = $(this).find("option:selected").text();
  console.log("Selected ID:", selectedId);
  console.log("Selected Name:", selectedName);
});








$('#load-films-ids').click((e) => {
  e.preventDefault();

  $.ajax({
    url: 'http://localhost:8080/api/v1/film/get', // Updated URL
    type: 'GET',
    success: (res) => {
      console.log(res);

      // Clear existing options
      $('#load-films-id').empty();

      // Add default option
      $('#load-films-id').append('<option value="">-- Select Time Table --</option>');

      // Add options from response data
      if (res.data && res.data.length > 0) {
        res.data.forEach(spice => { // Updated variable name
          $('#load-films-id').append(`<option value="${spice.id}">${spice.title}</option>`);
        });
      } else {
        console.log("No data found in response");
      }
    },
    error: (err) => {
      console.log(err);
    }
  });
});

// Optional: To capture the selected value
$('#load-films-id').change(function() {
  const selectedId = $(this).val();
  const selectedName = $(this).find("option:selected").text();
  console.log("Selected ID:", selectedId);
  console.log("Selected Name:", selectedName);
});



$('#btn_save_customer').click((e) => {
  e.preventDefault();
  const filmRegistrationId = $("#id").val();

  // Get the selected values from dropdowns
  const filmHallId = $('#load-hall-id').val();
  const timeTableId = $('#load-film-id').val();
  const filmId = $('#load-films-id').val();

  // Make sure all required fields are filled
  if (!filmRegistrationId || !filmHallId || !timeTableId || !filmId) {
    alert("Please fill in all required fields");
    return;
  }

  // Create data object matching your DTO structure
  const filmRegistrationData = {
    id: filmRegistrationId,
    filmHall: {
      id: filmHallId
    },
    timeTable: {
      id: timeTableId
    },
    film: {
      id: filmId
    }
  };

  $.ajax({
    url: 'http://localhost:8080/api/v1/film-registration/save',
    type: "POST",
    data: JSON.stringify(filmRegistrationData),
    contentType: "application/json",
    success: (res) => {
      console.log(res);
       getAllCustomer();
      alert("Film registration saved successfully!");
      $('#customerModal').modal('hide');
      // Clear form or reload table as needed
      clearForm();
      // Add a function to reload data if you have one
    },
    error: (err) => {
      console.log(err);
      alert("Error saving film registration: " + (err.responseJSON?.message || "Unknown error"));
    }
  });
});

// Add this function to clear the form
function clearForm() {
  $("#id").val("");
  $('#load-hall-id').val("");
  $('#load-film-id').val("");
  $('#load-films-id').val("");
}







const getAllCustomer=()=>{
  $.ajax({
    url: 'http://localhost:8080/api/v1/film-registration/getAll',
    type: "GET",
    success:(res) =>{
      console.log(res)
      $('#customer_table_body').empty()
      res.data.forEach(customer => {
        $('#customer_table_body').append(`
                 <tr>
                    <td>${customer.id}</td>
                       <td>${customer.hallName}</td>
                    <td>${customer.filmTitle}</td>
                      <td>${customer.timeDescription}</td>

                     <td>
                          <button class="btn btn-light btn-sm" onclick="editCustomer('${customer.id}','${customer.hallName}','${customer.filmTitle}' ,'${customer.timeDescription}')" >
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


const deleteCustomer=(id) =>{
  $.ajax({
    url:`http://localhost:8080/api/v1/film-registration/delete/${id}`,
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





$('#updated_load-cus-ids').click((e) => {
  e.preventDefault();

  $.ajax({
    url: 'http://localhost:8080/api/v1/time-table/getAll',
    type: 'GET',
    success: (res) => {
      console.log(res);

      // Clear existing options
      $('#updated_load-film-id').empty();

      // Add default option
      $('#updated_load-film-id').append('<option value="">-- Select Time Table --</option>');

      // Add options from response data
      if (res.data && res.data.length > 0) {
        res.data.forEach(film => {
          $('#updated_load-film-id').append(`<option value="${film.id}">${film.description}</option>`);
        });
      } else {
        console.log("No data found in response");
      }
    },
    error: (err) => {
      console.log(err);
    }
  });
});

// Optional: To capture the selected value
$('#updated_load-film-id').change(function() {
  const selectedId = $(this).val();
  const selectedName = $(this).find("option:selected").text();
  console.log("Selected ID:", selectedId);
  console.log("Selected Name:", selectedName);

  // You can use these values as needed
  // For example, populate other fields:
  // $('#someOtherField').val(selectedId);
});







$('#updated_load-hall-ids').click((e) => {
  e.preventDefault();

  $.ajax({
    url: 'http://localhost:8080/api/v1/example/get', // Updated URL
    type: 'GET',
    success: (res) => {
      console.log(res);

      // Clear existing options
      $('#updated_load-hall-id').empty();

      // Add default option
      $('#updated_load-hall-id').append('<option value="">-- Select Time Table --</option>');

      // Add options from response data
      if (res.data && res.data.length > 0) {
        res.data.forEach(spice => { // Updated variable name
          $('#updated_load-hall-id').append(`<option value="${spice.id}">${spice.name}</option>`);
        });
      } else {
        console.log("No data found in response");
      }
    },
    error: (err) => {
      console.log(err);
    }
  });
});



$('#updated_load-films-ids').click((e) => {
  e.preventDefault();

  $.ajax({
    url: 'http://localhost:8080/api/v1/film/get', // Updated URL
    type: 'GET',
    success: (res) => {
      console.log(res);

      // Clear existing options
      $('#updated_load-films-id').empty();

      // Add default option
      $('#updated_load-films-id').append('<option value="">-- Select Time Table --</option>');

      // Add options from response data
      if (res.data && res.data.length > 0) {
        res.data.forEach(spice => { // Updated variable name
          $('#updated_load-films-id').append(`<option value="${spice.id}">${spice.title}</option>`);
        });
      } else {
        console.log("No data found in response");
      }
    },
    error: (err) => {
      console.log(err);
    }
  });
});



const editCustomer = (id,hallName ,  filmTitle ,timeDescription) => {
  // Open the update modal
  $('#updateCustomerModal').modal('show');

  // Set the values in the form fields
  $('#updated_id').val(id);



  if ($('#updated_load-film-id option[value="' + timeDescription + '"]').length === 0) {
    $('#updated_load-film-id').append('<option value="' + timeDescription + '">' + timeDescription + '</option>');
  }

  // Set the dropdown value to hallName
  $('#updated_load-film-id').val(timeDescription);




  if ($('#updated_load-hall-id option[value="' + hallName + '"]').length === 0) {
    $('#updated_load-hall-id').append('<option value="' + hallName + '">' + hallName + '</option>');
  }

  // Set the dropdown value to hallName
  $('#updated_load-hall-id').val(hallName);



  if ($('#updated_load-films-id option[value="' +  filmTitle + '"]').length === 0) {
    $('#updated_load-films-id').append('<option value="' + filmTitle + '">' + filmTitle + '</option>');
  }

  // Set the dropdown value to hallName
  $('#updated_load-films-id').val(filmTitle);

}





$('#btn_update_customer').click((e) => {
  e.preventDefault();

  const seatId = $("#updated_id").val();

  const seatTypeId = $('#updated_load-film-id').val();
  const filmHallId = $('#updated_load-hall-id').val();
  const fil = $('#updated_load-films-id').val();

  const seatData = {
    id: seatId,

     timeTable: {
      id: seatTypeId
    },
    filmHall: {
      id: filmHallId
    },

    film: {
      id: fil
    },
  };

  $.ajax({
    url: 'http://localhost:8080/api/v1/film-registration/update',
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
})
