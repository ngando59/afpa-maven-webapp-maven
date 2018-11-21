function changeALaUne(lien) {
    var alaune = document.getElementById("alaune");
    var thumbOld = getAllElementsWithAttribute("data-id", alaune.getAttribute("data-id"));
    thumbOld.classList.remove("active");

    var lienSrc = lien.src;
    var lienSrcID = lien.getAttribute("data-id");
    alaune.src = lienSrc;
    alaune.setAttribute("data-id", lienSrcID);

    var thumb = getAllElementsWithAttribute("data-id", lienSrcID);
    thumb.classList.add("active");

}

filterInt = function (value) {
    if (/^(\-|\+)?([0-9]+|Infinity)$/.test(value))
        return Number(value);
    return NaN;
}

function scrollNext() {
    var alaune = document.getElementById("alaune");
    var currentID = alaune.getAttribute("data-id");
    var next = filterInt(currentID)+1;
    var thumbnailsElt = document.getElementsByClassName("thumbnail");
    if(next==thumbnailsElt.length){
        next = 0;
    }
    changeALaUne(thumbnailsElt[next]);
}

function scrollPred() {
    var alaune = document.getElementById("alaune");
    var currentID = alaune.getAttribute("data-id");
    var pred = filterInt(currentID)-1;
    var thumbnailsElt = document.getElementsByClassName("thumbnail");
    if(pred==-1){
        pred = thumbnailsElt.length-1;
    }
    changeALaUne(thumbnailsElt[pred]);
}

function getAllElementsWithAttribute(attribute, value){
    var thumbnailsElt = document.getElementsByClassName("thumbnail");
    for (var i = 0; i < thumbnailsElt.length; i++) {
        if (thumbnailsElt[i].getAttribute(attribute) == value) {
            return thumbnailsElt[i];
        }
    }
    return null;
}

function init() {
    var alaune = document.getElementById("alaune");
    var thumbOld = getAllElementsWithAttribute("data-id", alaune.getAttribute("data-id"));
    thumbOld.classList.add("active");
}


init();

var thumbnailsElt = document.getElementsByClassName("thumbnail");
var navNext = document.getElementById("navNext");
var navPred = document.getElementById("navPred");

for(var i=thumbnailsElt.length-1; i >= 0; i--){
    thumbnailsElt[i].addEventListener("click", function(){
        changeALaUne(this);
    });
}
navNext.addEventListener("click", function () {
    scrollNext();
});

navPred.addEventListener("click", function () {
    scrollPred();
});