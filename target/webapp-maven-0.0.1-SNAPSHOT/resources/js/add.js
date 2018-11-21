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

function valideAddForm() {
    var thumbnail = $("#addFrom input[name=thumbnail]");
    var title = $("#addFrom input[name=title]");
    var description = $("#addFrom textarea[name=description]");
    var price = $("#addFrom input[name=price]");
    var category = $("#addFrom select[name=category]");
    
    var submissible = true;

    if(!isValide(thumbnail,"Entre la photo du produit stp !")) {
        submissible = false;
    }
    if(!isValide(title,"Entre le nom du produit stp !")) {
        submissible = false;
    }
    if(!isValide(description,"Entre la description du produit stp !")) {
        submissible = false;
    }
    if(!isValide(price,"Entre le prix produit stp !")) {
        submissible = false;
    }    
    if(!isValide(category,"Entre la catégorie du produit stp !")) {
        submissible = false;
    }

    return submissible;
}

function valideUpdateForm() {
    var thumbnail = $("#updateFrom input[name=thumbnail]");
    var title = $("#updateFrom input[name=title]");
    var description = $("#updateFrom textarea[name=description]");
    var price = $("#updateFrom input[name=price]");
    var category = $("#updateFrom select[name=category]");
    
    var submissible = true;

    if(!isValide(thumbnail,"Entre la photo du produit stp !")) {
        submissible = false;
    }
    if(!isValide(title,"Entre le nom du produit stp !")) {
        submissible = false;
    }
    if(!isValide(description,"Entre la description du produit stp !")) {
        submissible = false;
    }
    if(!isValide(price,"Entre le prix produit stp !")) {
        submissible = false;
    }    
    if(!isValide(category,"Entre la catégorie du produit stp !")) {
        submissible = false;
    }

    return submissible;
}