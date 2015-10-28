package com.ostusa;

public class ClientSideScripts {
	
	public static final String WaitForAngular = "var el = document.querySelector(arguments[0]); var callback = arguments[1];angular.element(el).injector().get(\'$browser\').notifyWhenNoOutstandingRequests(callback);";
	
	public static final String TestForAngular = "var attempts = arguments[0]; var callback = arguments[arguments.length - 1];	var check = function(n) { if (window.angular && window.angular.resumeBootstrap) { callback(true); } else if (n < 1) { callback(false); } else { window.setTimeout(function() {check(n - 1)}, 1000); } }; check(attempts);";

	public static final String ResumeAngularBootstrap = "angular.resumeBootstrap(arguments[0].length ? arguments[0].split(',') : []);";
	
	public static final String GetLocationAbsUrl = "var el = document.querySelector(arguments[0]);	return angular.element(el).injector().get('$location').absUrl();";
	
	public static final String Evaluate = "var element = arguments[0];	var expression = arguments[1];	return angular.element(element).scope().$eval(expression);";
	
	public static final String FindBindings = "var using = arguments[0] || document; var binding = arguments[1]; var bindings = using.getElementsByClassName('ng-binding'); var matches = []; for (var i = 0; i < bindings.length; ++i) { var bindingName = angular.element(bindings[i]).data().$binding[0].exp || angular.element(bindings[i]).data().$binding; if (bindingName.indexOf(binding) != -1) { matches.push(bindings[i]);}	} return matches;";
	
	public static final String FindModel = "var using = arguments[0] || document;	var model = arguments[1];	var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-', 'ng\\\\:'];	for (var p = 0; p < prefixes.length; ++p) {	    var selector = '[' + prefixes[p] + 'model=\\\"' + model + '\\\"]';	    var inputs = using.querySelectorAll(selector);	    if (inputs.length) {	        return inputs;	    }	}";
	
	public static final String FindSelectedOptions = "var using = arguments[0] || document;	var model = arguments[1];	var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-', 'ng\\:'];	for (var p = 0; p < prefixes.length; ++p) {	    var selector = 'select[' + prefixes[p] + 'model=\"\"' + model + '\"\"] option:checked';	    var inputs = using.querySelectorAll(selector);	    if (inputs.length) {	        return inputs;	    }	}";
	
	public static final String FindAllRepeaterRows = "var using = arguments[0] || document; var repeater = arguments[1]; var rows = []; var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-', 'ng\\\\:']; for (var p = 0; p < prefixes.length; ++p) { var attr = prefixes[p] + 'repeat'; var repeatElems = using.querySelectorAll('[' + attr + ']'); attr = attr.replace(/\\\\/g, ''); for (var i = 0; i < repeatElems.length; ++i) { if (repeatElems[i].getAttribute(attr).indexOf(repeater) != -1) { rows.push(repeatElems[i]); } } } for (var p = 0; p < prefixes.length; ++p) { var attr = prefixes[p] + 'repeat-start'; var repeatElems = using.querySelectorAll('[' + attr + ']'); attr = attr.replace(/\\\\/g, ''); for (var i = 0; i < repeatElems.length; ++i) { if (repeatElems[i].getAttribute(attr).indexOf(repeater) != -1) { var elem = repeatElems[i]; while (elem.nodeType != 8 || !(elem.nodeValue.indexOf(repeater) != -1)) { if (elem.nodeType == 1) { rows.push(elem); } elem = elem.nextSibling; } } } } return rows;";
	//public static final String FindAllRepeaterRows = "var using = arguments[0] || document; var repeater = arguments[1]; var rows = []; var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-', 'ng\\:']; for (var p = 0; p < prefixes.length; ++p) { var attr = prefixes[p] + 'repeat'; var repeatElems = using.querySelectorAll('[' + attr + ']'); attr = attr.replace(/\\/, ''); for (var i = 0; i < repeatElems.length; ++i) { if (repeatElems[i].getAttribute(attr).indexOf(repeater) != -1) { rows.push(repeatElems[i]); } } } for (var p = 0; p < prefixes.length; ++p) { var attr = prefixes[p] + 'repeat-start'; var repeatElems = using.querySelectorAll('[' + attr + ']'); attr = attr.replace(/\\/, ''); for (var i = 0; i < repeatElems.length; ++i) { if (repeatElems[i].getAttribute(attr).indexOf(repeater) != -1) { var elem = repeatElems[i]; while (elem.nodeType != 8 || !(elem.nodeValue.indexOf(repeater) != -1)) { if (elem.nodeType == 1) { rows.push(elem); } elem = elem.nextSibling; } } } } return rows;";
	

}
