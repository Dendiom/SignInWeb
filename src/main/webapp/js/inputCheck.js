function usernameCheck (username) {
    var brief = username.trim();
    if (brief.length < 6 || brief.length > 15) {
        alert("请输入6~15位用户名");
        return false;
    }

    return true;
}