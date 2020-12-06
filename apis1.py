# practicing basic API integration with python
# 12.5.20

import requests
response = requests.get("http://api.open-notify.org/iss-now.json")
print(response.status_code)
