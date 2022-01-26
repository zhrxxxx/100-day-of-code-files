//let changeColor = document.getElementById("changeColor");
//let changeColorPurple = document.getElementById("changeColor");
//let changeColorBlue = document.getElementById("changeColor");

chrome.storage.sync.get("color", ({ color }) => {
    changeColor.style.backgroundColor = color;
});


changeColor.addEventListener("click", async () => {
    let [tab] = await chrome.tabs.query({ active: true, currentWindow: true });

    chrome.scripting.executeScript({
        target: { tabId: tab.id },
        function: setPageBackgroundColorBlack,
    });
});


function setPageBackgroundColorBlack() {
    chrome.storage.sync.get("color", ({ color }) => {
        document.body.style.backgroundColor = color;
    });
}