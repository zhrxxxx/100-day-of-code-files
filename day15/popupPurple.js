chrome.storage.sync.get("colorPurple", ({ colorPurple }) => {
    changeColorPurple.style.backgroundColor = colorPurple;
});

changeColorPurple.addEventListener("click", async () => {
    let [tab] = await chrome.tabs.query({ active: true, currentWindow: true });

    chrome.scripting.executeScript({
        target: { tabId: tab.id },
        function: setPageBackgroundColorPurple,
    });
});


function setPageBackgroundColorPurple() {
    chrome.storage.sync.get("colorPurple", ({ colorPurple }) => {
        document.body.style.backgroundColor = colorPurple;
    });
}