function getChildByClass(parent, childClass) {
    var notes = null;
    for (var i = 0; i < parent.childNodes.length; i++) {
        if (parent.childNodes[i].className == childClass) {
            notes = parent.childNodes[i];
            break;
        }
    }
    return notes;
}

function isValide(input, messageError){
    var submissible = true;
    if(input.val().trim() === ''){
        submissible = false;
        printError(input, messageError);
    } else {
        submissible = true;
        removeError(input);
    }
    return submissible;
}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function valideContactForm() {
    var nom = document.forms["contact"]["nom"];
    var email = document.forms["contact"]["email"];
    var objet = document.forms["contact"]["objet"];
    var message = document.forms["contact"]["message"];

    var submissible = true;

    if(nom.value.trim() === ''){
        nom.classList.add("required");
        submissible = false;
        var error = getChildByClass(nom.parentNode, "error");
        error.innerHTML = "Entre ton nom stp !";
    } else {
        nom.classList.remove("required");
        var error = getChildByClass(nom.parentNode, "error");
        error.innerHTML = "";
    }

    if(email.value.trim() === ''){
        email.classList.add("required");
        submissible = false;
        var error = getChildByClass(email.parentNode, "error");
        error.innerHTML = "Entre ton adresse email stp !";
    } else {
        if(!validateEmail(email.value)) {
            submissible = false;
            var error = getChildByClass(email.parentNode, "error");
            error.innerHTML = ":( Ton adresse email est bidon !";
        } else {
            submissible = true;
            email.classList.remove("required");
            var error = getChildByClass(email.parentNode, "error");
            error.innerHTML = "";
        }
    }

    if(objet.value.trim() === ''){
        objet.classList.add("required");
        submissible = false;
        var error = getChildByClass(objet.parentNode, "error");
        error.innerHTML = "Entre ton objet de message stp !";
    } else {
        objet.classList.remove("required");
        var error = getChildByClass(objet.parentNode, "error");
        error.innerHTML = "";
    }

    if(message.value.trim() === ''){
        message.classList.add("required");
        submissible = false;
        var error = getChildByClass(message.parentNode, "error");
        error.innerHTML = "Entre ton message stp !";
    } else {
        message.classList.remove("required");
        var error = getChildByClass(message.parentNode, "error");
        error.innerHTML = "";
    }

    return submissible;
}