LoadResources
=============

This project demonstrates a solution to an issue where if you use aapt to rename an apk's package then the loading resources using context.getResources().getIdentifier() doesn't load resource identifiers correctly.

After building the app, run it and look at the logs.  Notice that just calling context.getResources().getIdentifier() does not return an identifier.
