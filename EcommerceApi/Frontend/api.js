async function fetchProducts() {
  try {
    const response = await fetch("http://localhost:8080/api/products");

    // Manual HTTP status check
    if (!response.ok) {
      if (response.status === 404) {
        throw new Error("404: Products not found");
      } else if (response.status === 500) {
        throw new Error("500: Server error");
      } else {
        throw new Error(`HTTP Error: ${response.status}`);
      }
    }

    const data = await response.json();
    return data;

  } catch (error) {
    console.error("Error fetching products:", error.message);
    return []; // return empty array for safe UI handling
  }
}