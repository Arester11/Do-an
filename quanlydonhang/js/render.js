
function render() {
    let order = JSON.parse(localStorage.order);
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
    order.forEach((order, index) => {
        let temp = index;
        index++;
        table += `
            <tr>
                <td class="imagetd"><img src="${order.image}" width="80" height="80"></td>
                <td>${order.name}</td>
                <td>${order.price}</td>
                <td>${order.quantity}</td>
                <td>${order.price * order.quantity}</td>
                <td class="edittd">
                    <button class="buttontd" onclick="tick(${temp})"><i class="far fa-trash-alt"></i></button>
                    <button class="buttontd" onclick="confirm(${temp})"><i class="fas fa-check-circle"></i></button>
                </td>
            </tr>`;
    });
    document.getElementById("order").innerHTML = table;
    document.getElementById("main").innerHTML = main;
}

function rendershipping() {
    let order = JSON.parse(localStorage.shipping);
    let main = `
    <div>
        <button class="left" onclick="render()">Waiting Packaging</button>
    </div>
    <div>
        <button class="pressright">Waiting Shipping</button>
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
    order.forEach((order, index) => {
        let temp = index;
        index++;
        table += `
            <tr>
                <td class="imagetd"><img src="${order.image}" width="80" height="80"></td>
                <td>${order.name}</td>
                <td>${order.price}</td>
                <td>${order.quantity}</td>
                <td>${order.price * order.quantity}</td>
                <td class="edittd">
                    <button class="buttontd" onclick="removeshipping (${temp})"><i class="fas fa-dollar-sign"></i></button>
                </td>
            </tr>`;
    });
    document.getElementById("order").innerHTML = table;
    document.getElementById("main").innerHTML = main;
}

/****************ARE YOU SURE *************/

function tick(id) {
    document.getElementById("notice").style.display = "block";
    document.getElementById("notice").innerHTML = `
    <button class="exitnotice" onclick="no()"></button>
    <div class="areyousure">
        <div>Are You Sure?</div>
        <input class="yes" type="button" value="Yes" onclick="yes(${id})">
        <input class="no" type="button" value="No" onclick="no()">
    </div>
    `;
}

function no() {
    document.getElementById("notice").style.display = "none";
}

function yes(id) {
    cancel(id);
    document.getElementById("notice").style.display = "none";
}