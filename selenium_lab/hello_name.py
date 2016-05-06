from selenium import webdriver
driver=webdriver.Firefox()
driver.implicitly_wait(30)
driver.get("http://www.google.co.in")
driver.find_element_by_id("lst-ib")