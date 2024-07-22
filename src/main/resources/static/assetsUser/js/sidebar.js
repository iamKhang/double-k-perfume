$(document).ready(function() {
  $('.admin_nav_link').click(function(e) {
    e.preventDefault(); // Ngăn chặn hành vi mặc định của liên kết
    var $subMenu = $(this).next('.serv-show');
    var $icon = $(this).find('.fas.fa-caret-down');

    $subMenu.toggleClass('active');
    $icon.toggleClass('active');
  });
});