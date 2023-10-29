
function searchorder() {
    let name = document.getElementById("search").value;
    let order = localStorage.order ? JSON.parse(localStorage.order) : [];
    let main = `
    <div>
        <button class="pressleft">Waiting Packaging</button>
    </div>
    <div>
        <button class="right" onclick="rendershipping()">Waiting Shipping</button>
    </div>
    `;
    let table = `
    <tr class="tableheader">
        <th class="image">Image</th>
        <th>Name</th>
        <th class="price">Price</th>
        <th class="quantity">Quantity</th>
        <th class="total">Total</th>
        <th class="edit">Edit</th>
    </tr>
    `;
    for (let i=0; i < order.length; i++) {
        if (order[i].name.toUpperCase().includes(name.toUpperCase()))
        {
            table += `
            <tr>
                <td class="imagetd"><img src="${order[i].image}" width="80" height="80"></td>
                <td>${order[i].name}</td>
                <td>${order[i].price}</td>
                <td>${order[i].quantity}</td>
                <td>${order[i].price * order[i].quantity}</td>
                <td class="edittd">
                    <button class="buttontd" onclick="cancel(${i})"><i class="far fa-trash-alt"></i></button>
                    <button class="buttontd" onclick="confirm(${i})"><i class="fas fa-check-circle"></i></button>
                </td>
            </tr>`;
        }
    }
    document.getElementById("order").innerHTML = table;
    document.getElementById("main").innerHTML = main;
}