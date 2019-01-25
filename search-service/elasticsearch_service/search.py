from elasticsearch_service.get_connection import get_connection_object
es = get_connection_object()

index_name = 'purchaser'
document = 'products'

class Search:

    def __init__(self, query):
        self.query = query
    
    def tokenize(self):
        return self.query.split()

    def create_filter_obj(self):
        return { 'query': { 'match': { 'name': self.query } } }

    def create_dto(self, get_hits):
        data = [ { 'id': hit['_id'], 'detail': hit['_source'] } for hit in get_hits ]
        return data

    def get_result(self):
        # result = self.tokenize()
        filter_obj = self.create_filter_obj()
        res = es.search(index = index_name, doc_type = document, body = filter_obj)
        get_hits = res['hits']['hits']
        return self.create_dto(get_hits)

    def get_all_result(self):
        res = es.search(index = index_name, doc_type = document)
        get_hits = res['hits']['hits']
        return self.create_dto(get_hits)

    def get_by_id(self, id):
        res = es.get(index = index_name, doc_type = document, id = id)
        return {'id': res['_id'], 'detail': res['_source'] }