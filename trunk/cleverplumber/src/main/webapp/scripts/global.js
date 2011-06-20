function openWindow(url, winTitle, winParams) {
	winName = window.open(url, winTitle, winParams);
	winName.focus();
}

function setCookie(name, value, expires, path, domain, secure) {
	document.cookie = name + "=" + escape(value) + ((expires) ? "; expires=" + expires.toGMTString() : "") + ((path) ? "; path=" + path : "") + ((domain) ? "; domain=" + domain : "") + ((secure) ? "; secure" : "");
}

function getCookie(name) {
	var prefix = name + "=";
	var start = document.cookie.indexOf(prefix);
	if (start == -1) {
		return null;
	}
	var end = document.cookie.indexOf(";", start + prefix.length);
	if (end == -1) {
		end = document.cookie.length;
	}
	var value = document.cookie.substring(start + prefix.length, end);
	return unescape(value);
}

function deleteCookie(name, path, domain) {
	if (getCookie(name)) {
		document.cookie = name + "=" + ((path) ? "; path=" + path : "") + ((domain) ? "; domain=" + domain : "") + "; expires=Thu, 01-Jan-70 00:00:01 GMT";
	}
}

function confirmDelete(obj) {
	var msg = "Are you sure you want to delete this " + obj + "?";
	ans = confirm(msg);
	if (ans) {
		return true;
	} else {
		return false;
	}
}
function confirmRemove(obj) {
	var msg = "Are you sure you want to remove this " + obj + "?";
	ans = confirm(msg);
	if (ans) {
		return true;
	} else {
		return false;
	}
}
function confirmGeneral(obj) {
	
	ans = confirm(obj);
	if (ans) {
		return true;
	} else {
		return false;
	}
}

function addLoadEvent(func) {
	var oldonload = window.onload;
	if (typeof window.onload != "function") {
		window.onload = func;
	} else {
		window.onload = function () {
			if (oldonload) {
				oldonload();
			}
			func();
		};
	}
}

function initMenu() {
	var uls = document.getElementsByTagName("ul");
	for (i = 0; i < uls.length; i++) {
		if (uls[i].className == "menuList") {
			decorateMenu(uls[i]);
		}
	}
}

function decorateMenu(menu) {
	var items = menu.getElementsByTagName("li");
	for (var i = 0; i < items.length; i++) {
		items[i].firstChild.myIndex = i;
        
		if (items[i].firstChild.onclick) {
			items[i].firstChild.onclick = function () {
				eval(items[this.myIndex].firstChild.getAttribute("onclick"));
				setCookie("menuSelected", this.myIndex);
			};
		} else {
			items[i].firstChild.onclick = function () {
				setCookie("menuSelected", this.myIndex);
			};
		}
	}
	activateMenu(items);
}

function activateMenu(items) {
	var activeMenu;
	var menuSelected = getCookie("menuSelected");
	if (menuSelected == null) {
		menuSelected = 0;
	}
		
	$(items[menuSelected]).addClass("selected");
}

function setMenu0() {
	setCookie('menuSelected',0)
}

function setMenu1() {
	setCookie('menuSelected',1)
}

function setMenu2() {
	setCookie('menuSelected',2)
}

function setMenu3() {
	setCookie('menuSelected',3)
}

function clearMenuSelection() {
	deleteCookie("menuSelected");
}

addLoadEvent(initMenu);

window.defaultStatus = document.title;

function selected(cal, date) {
    cal.sel.value = date;
    if (cal.dateClicked) {
        cal.callCloseHandler();
    }
}

function closeHandler(cal) {
    cal.hide();
}

function showCalendar(id, showId) {
                
    var inputElement = document.getElementById(id);
    var showElement = document.getElementById(showId);
                     
                        
    var cal = new Calendar(1, null, selected, closeHandler);
    cal.weekNumbers = true;

    cal.setRange(1900, 2070);
    cal.create();
    cal.setDateFormat('%d/%m/%Y');
    cal.parseDate(inputElement.value);
    cal.sel = inputElement;
    cal.showAtElement(showElement, "Br"); // show the calendar bottom right

    return false;
}

function showCalendarWithTime(id, showId) {
                
    var inputElement = document.getElementById(id);
    var showElement = document.getElementById(showId);
                     
                        
    var cal = new Calendar(1, null, selected, closeHandler);
    cal.weekNumbers = true;
    cal.showsTime = true;

    cal.setRange(1900, 2070);
    cal.create();
    cal.setDateFormat('%d/%m/%Y %H:%M');
    cal.parseDate(inputElement.value);
    cal.sel = inputElement;
    cal.showAtElement(showElement, "Br"); // show the calendar bottom right

    return false;
}

function changeJobTitle(jobRole, jobTitle)
{
	var keyselection = document.getElementById(jobRole); 
	var keyvalue = keyselection.options[keyselection.selectedIndex]; 
	document.getElementById(jobTitle).value = keyvalue.text;
}


