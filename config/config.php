<?php

defined('ENABLE_URL_REWRITE') or define('ENABLE_URL_REWRITE', true);
defined('LOG_DRIVER') or define('LOG_DRIVER', 'system');
// set header parameter name for api requests 
define('API_AUTHENTICATION_HEADER', 'X-API-Auth');