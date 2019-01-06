from elasticsearch import Elasticsearch
from config.config import ElasticSearchConfig as config

hosts = [{'host': config.HOST, 'port': config.PORT}]
 
def get_connection_object():
    return Elasticsearch(hosts, http_compress=True)