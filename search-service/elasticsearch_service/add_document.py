from elasticsearch_service.get_connection import get_connection_object
es = get_connection_object()

class Add: 
    def __init__(self, product):
        self.product = product

    def add(self):
