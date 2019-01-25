from elasticsearch_service.get_connection import get_connection_object
es = get_connection_object()

index_name = 'purchaser'
document_type = 'products'

class Add: 
    def __init__(self, product):
        self.product = product

    def add(self, id):
        result = es.create(index = index_name, doc_type = document_type, body = self.product, id = id)
        return result

    def update(self, id)
        result = es.update(index = index_name, doc_type = document_type, body = self.product, id = id)
        return result