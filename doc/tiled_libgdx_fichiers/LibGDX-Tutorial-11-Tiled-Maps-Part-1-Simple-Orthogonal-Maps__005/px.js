(function() {
 
  'use strict';
 
  // INIT
  var _hn_ver = 6,
    _ref = encodeURIComponent(document.referrer),
    _kwQuery = window.captify_kw_query_11954 ? '&kw=' + encodeURIComponent(captify_kw_query_11954) : '',
    _dspSyncUrl = 'https://s.cpx.to/dspSync?',
    _anxUrl = 'https://secure.adnxs.com/getuid?',
    _pid = 11954,
    _uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
      var r = Math.random() * 16 | 0,
        v = c == 'x' ? r : (r & 0x3 | 0x8);
      return v.toString(16);
    }),
    _groupParams = 'pid=' + _pid + '&ref=' + _ref + '&hn_ver=' + _hn_ver + '&fid=' + _uuid + _kwQuery;
 
 
  (new Image()).src = _dspSyncUrl + _groupParams;
 
// Avocet ID sync
        (new Image()).src = _anxUrl + encodeURIComponent('https://ads.avocet.io/sync?invsrc=5575b5a3d6e9d6ab4a43bc78&ext_uid=$UID');
 
})(window);