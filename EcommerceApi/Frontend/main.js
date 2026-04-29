function renderProducts(products) {
  const main = document.querySelector("main");

  if (!products || products.length === 0) {
    main.innerHTML = `
      <div class="empty-state">
        <h2>No products available</h2>
        <p>Please check back later.</p>
      </div>
    `;
    return;
  }

  const html = `
    <div class="product-grid">
      ${products
        .map(
          (product) => `
          <div class="product-card">
            <h3>${product.name}</h3>
            <p>Price: ₱${product.price}</p>
            <p>Category: ${product.category?.name || "N/A"}</p>
          </div>
        `
        )
        .join("")}
    </div>
  `;

  main.innerHTML = html;
}


// Page load logic
document.addEventListener("DOMContentLoaded", async () => {
  const products = await fetchProducts();
  renderProducts(products);
});