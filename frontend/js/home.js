//
// $(document).ready(function (){
//   getAllCustomer();
// })
//
//
//
//
// const getAllCustomer = () => {
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/film/get',
//     type: "GET",
//     success: (res) => {
//       console.log(res);
//
//       $('#carouselItems').empty(); // Clear existing carousel items
//
//       res.data.forEach((customer, index) => {
//         const imageUrl = customer.imageUrl ? `data:image/png;base64,${customer.imageUrl}` : 'assets/Images/noImage.png';
//
//
//         // Populate the carousel
//         const activeClass = index === 0 ? 'active' : ''; // Set the first item as active
//         $('#carouselItems').append(`
//           <div class="carousel-item ${activeClass}">
//             <img src="${imageUrl}" class="d-block w-100" alt="${customer.title}">
//             <div class="carousel-caption d-none d-md-block">
//               <h5>${customer.title}</h5>
//               <p>${customer.description}</p>
//             </div>
//           </div>
//         `);
//       });
//     },
//     error: (err) => {
//       console.log(err);
//     }
//   });
// };


//
// $(document).ready(function (){
//   getAllCustomer();
// })
//
// const getAllCustomer = () => {
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/film/get',
//     type: "GET",
//     success: (res) => {
//       console.log(res);
//
//       $('#carouselItems').empty(); // Clear existing carousel items
//
//       res.data.forEach((customer, index) => {
//         const imageUrl = customer.imageUrl
//           ? `data:image/png;base64,${customer.imageUrl}`
//           : 'assets/Images/noImage.png';
//
//         // Populate the carousel
//         const activeClass = index === 0 ? 'active' : ''; // Set the first item as active
//         $('#carouselItems').append(`
//           <div class="carousel-item ${activeClass}">
//             <img src="${imageUrl}" class="d-block w-100" alt="${customer.title}">
//             <div class="carousel-caption d-none d-md-block">
//               <h5>${customer.title}</h5>
//               <p>${customer.description}</p>
//             </div>
//           </div>
//         `);
//       });
//     },
//     error: (err) => {
//       console.log(err);
//     }
//   });
// };




//
// $(document).ready(function (){
//   getAllCustomer();
// });
//
// const getAllCustomer = () => {
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/film/get',
//     type: "GET",
//     success: (res) => {
//       console.log(res);
//
//       $('#carouselItems').empty(); // Clear existing carousel items
//
//       res.data.forEach((customer, index) => {
//         const imageUrl = customer.imageUrl
//           ? `data:image/png;base64,${customer.imageUrl}`
//           : 'assets/Images/noImage.png';
//
//         // Populate the carousel
//         const activeClass = index === 0 ? 'active' : ''; // Set the first item as active
//         $('#carouselItems').append(`
//           <div class="carousel-item ${activeClass}">
//             <img src="${imageUrl}" class="d-block w-100" alt="${customer.title}">
//             <div class="carousel-caption d-none d-md-block">
//               <h5>${customer.title}</h5>
//               <p>${customer.description}</p>
//             </div>
//           </div>
//         `);
//       });
//
//       // Initialize carousel
//       $('#carouselExample').carousel({ interval: 2000 });  // Example of setting interval
//     },
//     error: (err) => {
//       console.log(err);
//     }
//   });
// };
//
// // Function to move to next carousel item
// const nextCarouselItem = () => {
//   $('#carouselExample').carousel('next');
// };
// $(document).ready(function (){
//   getAllCustomer();
// });
//
// const getAllCustomer = () => {
//   $.ajax({
//     url: 'http://localhost:8080/api/v1/film/get',
//     type: "GET",
//     success: (res) => {
//       console.log(res);
//
//       $('#carouselItems').empty(); // Clear existing carousel items
//
//       res.data.forEach((customer, index) => {
//         const imageUrl = customer.imageUrl
//           ? `data:image/png;base64,${customer.imageUrl}`
//           : 'assets/Images/noImage.png';
//
//         // Populate the carousel
//         const activeClass = index === 0 ? 'active' : ''; // Set the first item as active
//         $('#carouselItems').append(`
//           <div class="carousel-item ${activeClass}">
//             <img src="${imageUrl}" class="d-block w-100" alt="${customer.title}">
//             <div class="carousel-caption d-none d-md-block">
//               <h5>${customer.title}</h5>
//               <p>${customer.description}</p>
//             </div>
//           </div>
//         `);
//       });
//
//       // Initialize the carousel
//       $('#carouselExample').carousel({ interval: 5000 });  // Adjust interval as desired
//     },
//     error: (err) => {
//       console.log(err);
//     }
//   });
// };
//
// // Function to move to next carousel item
// const nextCarouselItem = () => {
//   $('#carouselExample').carousel('next');
// };
//
// // Function to move to previous carousel item
// const prevCarouselItem = () => {
//   $('#carouselExample').carousel('prev');
// };
$(document).ready(function (){
  getAllCustomer();
});

const getAllCustomer = () => {
  $.ajax({
    url: 'http://localhost:8080/api/v1/film/get',
    type: "GET",
    success: (res) => {
      console.log(res);

      // Clear existing carousel items and indicators
      $('#carouselItems').empty();
      $('#carouselIndicators').empty();

      res.data.forEach((customer, index) => {
        const imageUrl = customer.imageUrl
          ? `data:image/png;base64,${customer.imageUrl}`
          : 'assets/Images/noImage.png';

        // Create carousel indicators
        const indicatorActiveClass = index === 0 ? 'active' : '';
        $('#carouselIndicators').append(`
          <button type="button" data-bs-target="#carouselExample"
                  data-bs-slide-to="${index}"
                  class="${indicatorActiveClass}"
                  aria-current="${index === 0 ? 'true' : 'false'}"
                  aria-label="Slide ${index + 1}"></button>
        `);

        // Populate the carousel items
        const activeClass = index === 0 ? 'active' : '';
        $('#carouselItems').append(`
          <div class="carousel-item ${activeClass}">
            <img src="${imageUrl}" class="d-block w-100" alt="${customer.title}" style="object-fit: cover; height: 500px;">
            <div class="carousel-caption d-none d-md-block">
              <h5>${customer.title}</h5>
              <p>${customer.description}</p>
            </div>
          </div>
        `);
      });

      // Initialize the carousel
      const carouselElement = document.querySelector('#carouselExample');
      new bootstrap.Carousel(carouselElement, {
        interval: 5000,  // Change slide every 5 seconds
        ride: true       // Auto-cycle the carousel
      });
    },
    error: (err) => {
      console.log(err);
      alert('Error loading carousel items');
    }
  });
};



document.addEventListener('DOMContentLoaded', function() {
  fetchSpices();
  fetchSpices2();


});

function fetchSpices() {
  fetch('http://localhost:8080/api/v1/film/get')
    .then(response => response.json())
    .then(data => {
      const spiceContainer = document.getElementById('spiceContainer');
      spiceContainer.innerHTML = '';
      spiceContainer.className = 'row g-4 row-cols-1 row-cols-md-3 row-cols-lg-4 card-container';

      data.data.forEach((spice, index) => {
        const card = createSpiceCard(spice, index);
        spiceContainer.appendChild(card);
      });
    })
    .catch(error => {
      console.error('Error fetching spices:', error);
      const spiceContainer = document.getElementById('spiceContainer');
      spiceContainer.innerHTML = `
        <div class="col-12">
          <div class="alert alert-danger text-center" role="alert">
            Unable to load spices. Please try again later.
          </div>
        </div>
      `;
    });
}




function fetchSpices2() {
  fetch('http://localhost:8080/api/v1/up-film/get')
    .then(response => response.json())
    .then(data => {
      const spiceContainer = document.getElementById('spiceContainer2');
      spiceContainer.innerHTML = '';
      spiceContainer.className = 'row2 g-4 row-cols-1 row-cols-md-3 row-cols-lg-4 card-container';

      data.data.forEach((spice, index) => {
        const card = createSpiceCard(spice, index);
        spiceContainer.appendChild(card);
      });
    })
    .catch(error => {
      console.error('Error fetching spices:', error);
      const spiceContainer = document.getElementById('spiceContainer');
      spiceContainer.innerHTML = `
        <div class="col-12">
          <div class="alert alert-danger text-center" role="alert">
            Unable to load spices. Please try again later.
          </div>
        </div>
      `;
    });
}

function createSpiceCard(spice, index) {
  const card = document.createElement('div');
  card.className = 'col spice-card';

  const imageUrl = spice.imageUrl
    ? `data:image/png;base64,${spice.imageUrl}`
    : 'assets/images/no-image-placeholder.png';

  card.innerHTML = `
    <div class="card h-100 shadow-sm hover-lift transition-all duration-300 ease-in-out"
         style="
            transform-origin: center;
            transition: all 0.3s ease;
         "
         onmouseover="this.style.transform = 'scale(1.05)'; this.style.boxShadow = '0 10px 20px rgba(0,0,0,0.12)'"
         onmouseout="this.style.transform = 'scale(1)'; this.style.boxShadow = '0 4px 6px rgba(0,0,0,0.1)'"
    >
      <div class="card-image-container position-relative overflow-hidden" style="height: 250px;">
        <img
          src="${imageUrl}"
          class="card-img-top object-fit-cover w-100 h-100 transition-transform duration-300"
          alt="${spice.title} image"
          style="transition: transform 0.3s ease;"
        >
        <div class="image-overlay position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center justify-content-center opacity-0 bg-dark bg-opacity-50 text-white transition-all duration-300">
          <span class="text-center">Quick View</span>
        </div>
      </div>
      <div class="card-body d-flex flex-column">
        <h5 class="card-title text-truncate mb-2 fw-bold">${spice.title}</h5>
        <p class="card-text text-muted flex-grow-1 mb-3">
          ${spice.title || 'No description available'}
        </p>
        <div class="d-flex justify-content-between align-items-center">
          <span class="badge bg-primary rounded-pill">
            Now Screening
          </span>
          ${spice.price ? `
          <strong class="text-success">
            $${spice.price.toFixed(2)}
          </strong>` : ''}
        </div>
      </div>
      <div class="card-footer bg-transparent border-0 pt-0 pb-3">
        <div class="action-buttons d-flex flex-column gap-2">
          <button class="btn btn-outline-primary w-100 d-flex align-items-center justify-content-center" onclick="buyTicketsOnline(${index})">
            <i class="bi bi-ticket-detailed me-2"></i>Buy Tickets Online
          </button>
          <button class="btn btn-outline-secondary w-100 d-flex align-items-center justify-content-center" onclick="watchTrailer(${index})">
            <i class="bi bi-play-circle me-2"></i>Watch Trailer
          </button>
          <button class="btn btn-outline-info w-100 d-flex align-items-center justify-content-center" onclick="moreInfo(${index})">
            <i class="bi bi-info-circle me-2"></i>More Info
          </button>
        </div>
      </div>
    </div>
  `;

  // Add hover effects to image and overlay
  const imageContainer = card.querySelector('.card-image-container');
  const imageOverlay = card.querySelector('.image-overlay');

  imageContainer.addEventListener('mouseenter', () => {
    imageContainer.querySelector('img').style.transform = 'scale(1.1)';
    imageOverlay.classList.remove('opacity-0');
    imageOverlay.classList.add('opacity-100');
  });

  imageContainer.addEventListener('mouseleave', () => {
    imageContainer.querySelector('img').style.transform = 'scale(1)';
    imageOverlay.classList.remove('opacity-100');
    imageOverlay.classList.add('opacity-0');
  });

  return card;
}

function buyTicketsOnline(index) {
  const spice = globalSpiceData[index];
  console.log('Buying tickets for:', spice.title);
  alert(`Buying tickets for ${spice.title}`);
  // Implement ticket buying logic
}

function watchTrailer(index) {
  const spice = globalSpiceData[index];
  console.log('Watching trailer for:', spice.title);
  alert(`Opening trailer for ${spice.title}`);
  // Implement trailer viewing logic
}

function moreInfo(index) {
  const spice = globalSpiceData[index];
  console.log('More info for:', spice.title);
  alert(`More information about ${spice.title}`);
  // Implement more info logic
}

function filterSpices() {
  const filter = document.getElementById('filterInput').value.toLowerCase();
  const cards = document.getElementsByClassName('spice-card');

  Array.from(cards).forEach(card => {
    const name = card.querySelector('.card-title').textContent.toLowerCase();
    card.style.display = name.includes(filter) ? '' : 'none';
  });
}

// Global variable to store spice data
let globalSpiceData = [];







