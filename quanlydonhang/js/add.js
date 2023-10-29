
function addorder() {
    let image = document.getElementById('image').value;
    let name = document.getElementById('name').value;
    let price = document.getElementById('price').value;
    let quantity = document.getElementById('quantity').value;
    let order = JSON.parse(localStorage.order);
    order.push({
        image: image,
        name: name,
        price: price,
        quantity: quantity,
    });
    localStorage.order = JSON.stringify(order);
    console.log(order);
    render();
}

function addshipping(id) {
    let order = localStorage.order ? JSON.parse(localStorage.order) : [];
    let shipping = localStorage.shipping ? JSON.parse(localStorage.shipping) : [];
    shipping.push({
        image: order[id].image,
        name: order[id].name,
        price: order[id].price,
        quantity: order[id].quantity,
    });
    localStorage.shipping = JSON.stringify(shipping);
}