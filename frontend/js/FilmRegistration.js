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
                          <button class="btn btn-light btn-sm"  >
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


