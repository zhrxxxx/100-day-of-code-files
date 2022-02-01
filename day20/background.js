let color = '#18171c';
let colorPurple = '#2a0236';
let colorBlue = '#121264';

chrome.runtime.onInstalled.addListener(() => {
    chrome.storage.sync.set({ color });
    console.log('Default background color set to %cdark grey', `color: ${color}`);
    
});

chrome.runtime.onInstalled.addListener(() => {
chrome.storage.sync.set({ colorPurple });
    console.log('Default background color set to %cdark purple', `color: ${colorPurple}`);
});

chrome.runtime.onInstalled.addListener(() => {
    chrome.storage.sync.set({ colorBlue });
    console.log('Default background color set to %cdark blue', `color: ${colorBlue}`);
});