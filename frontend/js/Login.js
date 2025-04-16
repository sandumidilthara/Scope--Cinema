// Form submission
document.querySelector(".login-form").addEventListener("submit", async function (event) {
  event.preventDefault();

  const email = document.getElementById("emailSignIn").value;
  const password = document.getElementById("passwordSignIn").value;

  try {
    const response = await fetch("http://localhost:8080/api/v1/auth/authenticate", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email, password })
    });

    const data = await response.json();

    if (response.ok) {
      localStorage.setItem("token", data.data.token);
      localStorage.setItem("role", data.data.role);

      // Add these two lines right here
      console.log("Role received:", data.data.role);
      console.log("Role type:", typeof data.data.role);

      if (data.data.role === "ADMIN") {
        window.location.href = "dashboard.html";

      } else if (data.data.role === "USER") {
        window.location.href = "home.html";
      } else {
        alert("Invalid Role Assigned!");
      }
    } else {
      alert(data.message || "Invalid email or password!");
    }
  } catch (error) {
    console.log('Error:', error);
    if (error.status === 401) {
      Swal.fire('Invalid Credentials. Please try again.');
    } else {
      Swal.fire('Something went wrong! Error: ' + error.responseText);
    }
  }
});
