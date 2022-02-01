chrome.storage.sync.get("colorBlue", ({ colorBlue }) => {
    changeColorBlue.style.backgroundColor = colorBlue;
});

changeColorBlue.addEventListener("click", async () => {
    let [tab] = await chrome.tabs.query({ active: true, currentWindow: true });

    chrome.scripting.executeScript({
        target: { tabId: tab.id },
        function: setPageBackgroundColorBlue,
    });
});


function setPageBackgroundColorBlue() {
    chrome.storage.sync.get("colorBlue", ({ colorBlue }) => {
        document.body.style.backgroundColor = colorBlue;
    });
}