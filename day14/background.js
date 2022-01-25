function reddenPage() {

    document.body.style.backgroundColor = 'black';
}

chrome.action.onClicked.addListener((tab) => {
    chrome.scripting.executeScript({
        target: { tabId: tab.id },
        function: reddenPage
    });
});
