const API_BASE = "http://localhost:8081/api";
let cart = [];

async function init() {
    const [customers, factors, products] = await Promise.all([
        fetch(`${API_BASE}/costumer`).then(r => r.json()),
        fetch(`${API_BASE}/factor`).then(r => r.json()),
        fetch(`${API_BASE}/product`).then(r => r.json())
    ]);

    populateSelect('customerSelect', customers);
    populateSelect('factorSelect', factors);
    renderProducts(products);
}

function populateSelect(id, data) {
    const select = document.getElementById(id);
    data.forEach(item => {
        const opt = document.createElement('option');
        opt.value = item.id;
        opt.textContent = item.name + (item.lastname ? ` ${item.lastname}` : '');
        select.appendChild(opt);
    });
}

function renderProducts(products) {
    const table = document.getElementById('productTable');
    products.forEach(p => {
        const row = `<tr>
            <td>${p.name}</td>
            <td>$${p.price.toFixed(2)}</td>
            <td>${p.stock !== undefined ? p.stock : 'N/A'}</td>
            <td><input type="number" id="qty-${p.id}" class="form-control" style="width: 80px" value="1"></td>
            <td><button class="btn btn-sm btn-success" onclick="addToCart(${p.id}, '${p.name}', ${p.price})">Add</button></td>
        </tr>`;
        table.innerHTML += row;
    });
}

function addToCart(id, name, price) {
    const qty = parseInt(document.getElementById(`qty-${id}`).value);
    cart.push({ product: { id }, quantity: qty, price: price });
    updateTotal();
}

function updateTotal() {
    // Cálculo local aproximado (el real lo hace el backend)
    const total = cart.reduce((sum, item) => sum + (item.price * item.quantity), 0);
    document.getElementById('displayTotal').textContent = total.toFixed(2);
}

async function submitQuote() {
    const payload = {
        description: document.getElementById('quoteDesc').value,
        client: { id: document.getElementById('customerSelect').value },
        factor: { id: document.getElementById('factorSelect').value },
        products: cart
    };

    const response = await fetch(`${API_BASE}/pricing`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
    });

    if (response.ok) {
        alert("Pricing created successfully!");
        location.reload();
    } else {
        const error = await response.json();
        alert("Error: " + error.message);
    }
}

init();