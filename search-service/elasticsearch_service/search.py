from elasticsearch_service.get_connection import get_connection_object
es = get_connection_object()

index_name = 'purchaser'

class Search:

    def __init__(self, query):
        self.query = query
    
    def tokenize(self):
        return self.query.split()

    def get_result(self):
        # result = self.tokenize()
        res = es.search(index = index_name, body = self.query)
        return res