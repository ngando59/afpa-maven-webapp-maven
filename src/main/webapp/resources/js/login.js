function printError(input, messageError){
    input.addClass("required");
    input.parent().find(".error").html(messageError);
}

function removeError(input) {
    input.removeClass("required");
    input.parent().find(".error").html("");
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

function valideForm() {
    var civilite = $("#register input[name=civilite]");
    var nom = $("#register input[name=name]");
    var prenom = $("#register input[name=firstname]");
    var mail = $("#register input[name=email]");
    var password =$("#register input[name=password]");
    var confirmPassword = $("#register input[name=confirmPassword]");
    var dateNaissance = $("#register input[name=birthday]");
    var adresse = $("#register input[name=adress]");
    var ville = $("#register input[name=town]");
    var dept = $("#register input[name=department]");
    var pays = $("#register input[name=country]");

    var tel = $("#register input[name=phone]");
    //var commentaire = $("#register textarea[name=comments]");


    var submissible = true;

    if(!isValide(nom,"Entre ton nom stp !")) {
        submissible = false;
    }
    if(!isValide(prenom,"Entre ton prénom stp !")) {
        submissible = false;
    }
    if(!isValide(mail,"Entre ton adresse mail stp !")) {
        submissible = false;
    } else {
        if(!validateEmail(mail)) {
            submissible = false;
            printError(mail, ":( entre ta vrai adresse mail stp !");
        } else {
            submissible = true;
            removeError(mail);
        }
    }

    if((!isValide(password, "Entre ton mot de passe stp !"))||(!isValide(confirmPassword, "Confirme ton mot de passe stp !"))) {
        submissible = false;
    } else {
        if ( password.val() != confirmPassword.val() ) {
            printError(confirmPassword, ":( ta confirmation de mot de passe est différente de ton mot de passe !");
            submissible = false;
        } else {
            submissible = true;
            removeError(password);
            removeError(confirmPassword);
        }
    }

    if(!isValide(dateNaissance,"Entre ta date de naissance stp !")) {
        submissible = false;
    }

    if(tel.val().trim().length != 10) {
        submissible = false;
        printError(tel, ":( entre ton vrai numéro stp ! !");
    }
    /*if(!isValide(commentaire,"Entre ton commentaire stp !")) {
        submissible = false;
    }*/
    return submissible;
}

function valideLoginForm() {
    var login = $("#login input[name=login]");
    var password = $("#login input[name=password]");

    var submissible = true;

    if(!isValide(login,"Entre ton login stp !")) {
        submissible = false;
    }

    if(!isValide(password,"Entre ton mot de passe stp !")) {
        submissible = false;
    }

    return submissible;
}