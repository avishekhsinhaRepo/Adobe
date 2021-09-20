/* global jQuery, Coral */
(function($, Coral) {
    "use strict";
    var registry = $(window).adaptTo("foundation-registry");
    registry.register("foundation.validation.validator",{
        selector:"[data-validation=firstName-validation]",
        validate: function(element){
            var ele = $(element);
            var valueInTxtField = ele.val();
            var maximumChars = ele.data("max-char");
            var minimumChars = ele.data("min-char");
            var totalChars = ele.val().length;
            var pattern= /[a-z0-9]/g;
            if(totalChars > maximumChars){
                return valueInTxtField + " - Max 10 chars allowed"
            }else if(totalChars < minimumChars){
                return valueInTxtField + " - Not less than 2 chars allowed"
            }else if(pattern.test(valueInTxtField) ){
                return valueInTxtField + "can only be in uppercase";
            }
        }
    });
 })(jQuery, Coral);
