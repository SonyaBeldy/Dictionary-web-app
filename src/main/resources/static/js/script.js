let wrong_btn = document.getElementById("wrong-btn")
                        .addEventListener("click", (ev) => {
                            console.log("click");
}) 

function say(text) {
    alert(text);
}

let ind = 0;

document.getElementById('div0').style.display = 'block';

let i = 1;
while(document.getElementById('div' + i.toString()) != null) {
    let btn = document.getElementById('div' + i.toString()).style.display = 'none';
    i++;
}

function wrongCheck(isRight) {
    if (isRight) {
        alert("wrong answer");
    } else {
        alert("right answer");
    }
    document.getElementById('div' + (ind).toString()).style.display = 'none';
    document.getElementById('div' + (ind + 1).toString()).style.display = 'block';
    ind++;
    if(i >= ind) {
        
    }
}

function rightCheck(isRight) {
    if(isRight) {
        alert("right answer");
    } else {
        alert("wrong answer");
    }
    document.getElementById('div' + (ind).toString()).style.display = 'none';
    document.getElementById('div' + (ind + 1).toString()).style.display = 'block';
    ind++;
    if(i >= ind) {

    }
}

const styled = (display) =>
  `display: ${display};`


