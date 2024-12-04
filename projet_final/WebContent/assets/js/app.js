const icon = document.querySelector("#burger");
const menu = document.querySelector(".menu");
console.log(icon);

function toggler() {
  if (icon.textContent == `menu`) {
    icon.textContent = `close`;
    menu.style.left = "0px";
  } else {
    icon.textContent = `menu`;
    menu.style.left = "-250px";
  }
}