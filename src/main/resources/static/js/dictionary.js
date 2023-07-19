var checkbox = document.getElementById('checkbox-select-all');
//  var checkbox = document.querySelector('input[name=checkbox]');

 checkbox.addEventListener('change', function(){
    if(this.checked) {
        checkAllCheckboxes(true);

    } else {
        checkAllCheckboxes(false);
    }
 })

 function checkAllCheckboxes(checked) {
    var checkboxes = document.querySelectorAll("input[type=checkbox][id=checkbox]");
    checkboxes.forEach(function(checkbox) {
        checkbox.checked = checked;
    })
 }
