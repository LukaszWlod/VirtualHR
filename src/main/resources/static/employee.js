$('document').ready(function () {
    //show edit modal after click
    $('.table .edit').on('click', function (event) {
        event.preventDefault();
        console.log("employee edit")

        var href= $(this).attr('href');



         $.get(href, function(employee, status){
             $('#editId').val(employee.id);
            $('#editName').val(employee.name);
            $('#editPesel').val(employee.pesel);
            $('#editLastName').val(employee.lastName);
            $('#editEmail').val(employee.email);
            $('#editAddress').val(employee.address);
            $('#editPhone').val(employee.phoneNumber);

         });



         $('#editEmployee').modal('show');
    });
})
