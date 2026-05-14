var spider = {
    home: function(filter) { return JSON.stringify([]); },
    category: function(tid, pg, filter) { return JSON.stringify([]); },
    detail: function(ids) { return JSON.stringify([]); },
    search: function(key, quick) { return JSON.stringify([]); },
    player: function(flag, id) { return JSON.stringify({}); }
};