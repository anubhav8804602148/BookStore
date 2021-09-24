function filterSearch() {

  var input, filter, table, tr, td1, td2, i, txtValue1, txtValue2, txtValue;
  input = document.getElementById("searchBar");
  filter = input.value.toUpperCase();
  table = document.getElementById("bookTable");
  tr = table.getElementsByTagName("tr");


  for (i = 0; i < tr.length; i++) {
    td1 = tr[i].getElementsByTagName("td")[0]
	td2 = tr[i].getElementsByTagName("td")[1];
    if (td1 || td2) {
      txtValue1 = td1.textContent || td1.innerText;
      txtValue2 = td2.textContent || td2.innerText;
	  txtValue = txtValue1 + txtValue2;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
