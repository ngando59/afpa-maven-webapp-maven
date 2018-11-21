$("#qte").on('change', function() {
    var prixunitaire = parseFloat($("#prixUnitaire").html().replace(",", "."));
    var total = $(this).val()*prixunitaire
    $("#prixTotal").html(Number.parseFloat(total).toFixed(2)+" €");
});