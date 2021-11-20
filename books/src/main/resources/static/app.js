$('#loadBooks').click(() => {
    reloadBooks();
})



function reloadBooks() {

    $('#authors-container').empty();

    fetch("http://localhost:8080/books")
        .then(response => response.json())
        .then(json => json
            .forEach(book => {
            let tableRow = '<tr>' +
                '<th>'+ book.title +'</th>' +
                '<th>'+ book.author.name +'</th>' +
                '<th>'+ book.isbn +'</th>' +
                '<th>'+
                '<button class="edit-btn" data-book-id="'+book.id+'">Edit</button>' +
                '<button class="delete-btn" data-book-id="'+book.id+'">Delete</button>' +
                '</th>' +
                '<tr>'

                $("#authors-container").append(tableRow);
        }))
    // document.querySelector('.delete-btn').addEventListener('click',(ev)=>{console.log('deleted!' + ev.id)})
}
//
// <tr>
//     <th>Harry Poter</th>
//     <th>J. K. Rowling</th>
//     <th>0-7475-3269-9</th>
//     <th>
//         <button>Edit</button>
//         <button>Delete</button>
//     </th>
// </tr>
$('body').on('click','button.delete-btn',function () {
   let bookId = $(this).data('book-id');
   console.log(bookId.id)

    fetch('http://localhost:8080/books/' + bookId,{
        method: 'DELETE'
    }).then(() => reloadBooks());
});

