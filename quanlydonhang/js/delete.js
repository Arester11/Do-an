
function cancel(id) {
    let order = JSON.parse(localStorage.order);
    order.splice(id, 1);
    localStorage.order = JSON.stringify(order);
    render();
}

function confirm(id) {
    addshipping(id);
    cancel(id);
}

function removeshipping(id) {
    let shipping = localStorage.order ? JSON.parse(localStorage.shipping) : [];
    shipping.splice(id, 1);
    localStorage.shipping = JSON.stringify(shipping);
    rendershipping();
}
