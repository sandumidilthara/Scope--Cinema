

document.addEventListener('DOMContentLoaded', function() {
  fetchSpices();
});

function fetchSpices() {
  fetch('http://localhost:8080/api/v1/example/get')
    .then(response => response.json())
    .then(data => {
      const spiceContainer = document.getElementById('spiceContainer');
      spiceContainer.innerHTML = '';
      spiceContainer.className = 'row g-1 row-cols-1 row-cols-md-3 row-cols-lg-1 card-container';
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
  card.style.marginBottom = '20px'; // Adding margin for gap between cards
  card.style.width = '100px'; // Adjust width here
  card.style.height = '750px';
  const imageUrl = spice.imageURL
    ? `data:image/png;base64,${spice.imageURL}`
    : 'assets/images/no-image-placeholder.png';

  card.innerHTML = `
        <div class="card h-100 shadow-sm hover-lift transition-all duration-300"
            style="
                transform-origin: center;
                transition: all 0.3s ease;
            "
            onmouseover="this.style.transform = 'scale(1.05)'; this.style.boxShadow = '0 10px 20px rgba(0,0,0,0.12)'"
            onmouseout="this.style.transform = 'scale(1)'; this.style.boxShadow = '0 4px 6px rgba(0,0,0,0.1)'">
          <div class="card-image-container position-relative overflow-hidden" style="height: 450px;">
            <img
              src="${imageUrl}"
              class="card-img-top object-fit-cover w-100 h-100 transition-transform duration-300"
              alt="${spice.title} image"
              style="transition: transform 0.3s ease;">
            <div class="image-overlay position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center justify-content-center opacity-0 bg-dark bg-opacity-50 text-white transition-all duration-300">
              <span class="text-center">Quick View</span>
            </div>
          </div>
          <div class="card-body d-flex flex-column">
            <h5 class="card-title text-truncate mb-2 fw-bold">${spice.name}</h5>
            <p class="card-text text-muted flex-grow-1 mb-3">

              ${spice.name || 'No description available'}
            </p>

            <p class="card-text text-muted flex-grow-1 mb-3">

              ${spice.description|| 'No description available'}
            </p>


            <p class="card-text text-muted flex-grow-1 mb-3">
             <i class="fas fa-envelope"></i>
              ${spice.email || 'No description available'}
            </p>


            <p class="card-text text-muted flex-grow-1 mb-3">
             <i class="fas fa-phone-alt"></i>
              ${spice.contactNumber|| 'No description available'}
            </p>


            <p class="card-text text-muted flex-grow-1 mb-3">
              <i class="fas fa-map-marker-alt"></i>
              ${spice.location|| 'No description available'}
            </p>
          </div>
          <div class="card-footer bg-transparent border-0 pt-0 pb-3">
            <div class="action-buttons d-flex flex-column gap-2">
              <button class="btn btn-outline-primary w-100 d-flex align-items-center justify-content-center" onclick="buyTicketsOnline(${index})">
                <i class="bi bi-ticket-detailed me-2"></i>Buy Tickets Online
              </button>
            </div>
          </div>
        </div>
    `;

  // Hover effects for image and overlay
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

// Global variable to store spice data
let globalSpiceData = [];

function buyTicketsOnline(index) {
  const spice = globalSpiceData[index];
  console.log('Buying tickets for:', spice.title);
  alert(`Buying tickets for ${spice.title}`);
}

// Filter spices function
function filterSpices() {
  const filter = document.getElementById('filterInput').value.toLowerCase();
  const cards = document.getElementsByClassName('spice-card');

  Array.from(cards).forEach(card => {
    const name = card.querySelector('.card-title').textContent.toLowerCase();
    card.style.display = name.includes(filter) ? '' : 'none';
  });
}
