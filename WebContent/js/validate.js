// 手机号码验证
jQuery.validator.addMethod("mobile", function(value, element) {
    var length = value.length;
    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请检查您的手机号码");

// 下拉框验证
jQuery.validator.addMethod("select", function(value, element) {
    return value != '请选择角色';
}, "下拉框是必选项！");

// 用户名验证
jQuery.validator.addMethod("userName", function(value, element) {
    return value != '用户名已经存在';
}, "下拉框是必选项！");